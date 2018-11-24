package com.xm.zeronews.service.impl;

import com.xm.zeronews.pojo.Msg;
import com.xm.zeronews.dao.MsgMapper;
import com.xm.zeronews.service.MsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements MsgService {

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;
    @Autowired
    private MsgMapper msgMapper;

    @Override
    public void createWelcome(Long userId) {
        Msg msg = new Msg();
        msg.setUserId(userId);
        msg.setCreateTime(LocalDateTime.now());
        try {
            Map model = new HashMap();
            model.put("path","/#/home/details/update");
            Template template = freeMarkerConfig.getConfiguration().getTemplate("msg/welcome.html");
            try {
                String text = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
                msg.setContext(text);
                this.save(msg);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
