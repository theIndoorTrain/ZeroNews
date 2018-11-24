package com.xm.zeronews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan("com.xm.zeronews.dao")
@EnableAsync
@SpringBootApplication
public class ZeronewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeronewsApplication.class, args);
    }
}
