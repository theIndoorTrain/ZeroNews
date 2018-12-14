package com.xm.zeronews.controller;

import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.UserService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
@Api(value="FileController",tags="文件上传管理")
@RestController
@CrossOrigin
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private UserService userService;

    private Long MaxSize;
    @Value("${fileUpload.path}")
    private String path;
    @Value("${fileUpload.file}")
    private String filepaths;

    @ApiOperation(value="上传头像")
    @PostMapping("/head")
    public String uploadHead(MultipartFile file) {
        String filename = file.getOriginalFilename();
        return upload(file,false,"head"+filename.substring(filename.lastIndexOf('.')));
    }

    @ApiOperation(value="上传背景")
    @PostMapping("/bg")
    public String uploadBg(MultipartFile file) {
        String filename = file.getOriginalFilename();
        filename = upload(file,false,"bg"+filename.substring(filename.lastIndexOf('.')));
        User user = new User();
        user.setId(UserUtil.getUserId());
        user.setBg(filename);
        userService.updateById(user);
        return filename;
    }

    @ApiOperation(value="上传新闻图片")
    @PostMapping("/news")
    public String uploadNews(MultipartFile file) {
        String filename= null;
        try{
            filename= file.getOriginalFilename();
        } catch(Exception e) {
            e.printStackTrace();
        }

        filename = UUID.randomUUID().toString().replace("-", "").toLowerCase() + filename.substring(filename.lastIndexOf('.'));
        return upload(file,true,filename);
    }

    private String upload(MultipartFile file,Boolean isNews,String fileName) {
        File tmpfile = new File("/"+fileName);
        try {
            file.transferTo(tmpfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String filepath = filepaths;

        filepath += UserUtil.getUserId();
        File upFile = new File(path+filepath);
        if(!upFile.exists()) {
            upFile.mkdir();
        }
        if(isNews) {
            filepath += "/news";
            upFile = new File(path+filepath);
            if(!upFile.exists()) {
                upFile.mkdir();
            }
        }
        filepath += "/"+ fileName;
        upFile = new File(path,filepath);
        System.out.println("文件上传路径："+upFile.getAbsolutePath());

        if(tmpfile.renameTo(upFile)){
            System.out.println("文件上传成功！");
            return filepath;
        } else {
            System.out.println("文件上传失败！");
        }
        return null;

        /*FileChannel inChannel =null;
        FileChannel outChannel = null;
        try {
            inChannel =FileChannel.open(tmpfile.toPath(), StandardOpenOption.READ);
            *//**
             * StandardOpenOption.CREATE与StandardOpenOption.CREATE_NEW的区别
             * 1.StandardOpenOption.CREATE：无则创建，有则覆盖
             * 2.StandardOpenOption.CREATE_NEW：无则创建，有则报错
             *//*
            outChannel =FileChannel.open(upFile.toPath(), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
            //3.定义缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //4.读取数据到缓冲区,再从缓冲区写入到文件
            while(inChannel.read(buffer) != -1) {
                //切换到读模式
                buffer.flip();
                //写操作到管道
                outChannel.write(buffer);
                //清空buffer
                buffer.clear();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //5.关闭通道和流
            if(inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return filepath;
        }*/

    }


}
