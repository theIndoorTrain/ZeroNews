package com.xm.zeronews.controller;

import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
@Api(value="FileController",tags="文件上传管理")
@RestController
@RequestMapping("/upload")
public class FileController {

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
        return upload(file,false,"bg"+filename.substring(filename.lastIndexOf('.')));
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
        upFile = new File(path, filepath);
        try {
            file.transferTo(upFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }


}
