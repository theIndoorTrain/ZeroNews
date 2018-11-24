package com.xm.zeronews.service.impl;

import com.xm.zeronews.service.MailService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    /*@Override
    public void sendCode(String code, String email) {

        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("零点新闻------验证码");
            Context context = new Context();
            context.setVariable("code",code);
            String content = templateEngine.process("SendCode",context);
            helper.setText(content,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }*/

    @Async
    @Override
    public void sendCode(String code, String email) {

        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("零点新闻验证码");
            Map model = new HashMap();
            model.put("code",code);
            Template template = freeMarkerConfig.getConfiguration().getTemplate("SendCode.html");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setText(text,true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
}
