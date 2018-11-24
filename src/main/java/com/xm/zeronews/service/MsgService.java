package com.xm.zeronews.service;

import com.xm.zeronews.pojo.Msg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
public interface MsgService extends IService<Msg> {

    void createWelcome(Long userId);

}
