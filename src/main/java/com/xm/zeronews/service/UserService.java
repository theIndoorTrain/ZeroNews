package com.xm.zeronews.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-14
 */
public interface UserService extends IService<User> {

    User getWithLove(QueryWrapper<User> wrapper);

    IPage pageUser(IPage page, QueryWrapper<User> eq);

    IPage pageNews(IPage page, QueryWrapper<User> eq);
}
