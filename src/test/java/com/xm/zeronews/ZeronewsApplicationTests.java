package com.xm.zeronews;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xm.zeronews.pojo.Comment;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.CommentService;
import com.xm.zeronews.service.MailService;
import com.xm.zeronews.service.MsgService;
import com.xm.zeronews.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZeronewsApplicationTests {

    @Autowired
    private MsgService msgService;


    @Test
    public void msg() {
        msgService.createWelcome((long) 5);
    }


}
