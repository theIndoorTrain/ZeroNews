package com.xm.zeronews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.dao.UserMapper;
import com.xm.zeronews.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getWithLove(QueryWrapper<User> wrapper) {
        return userMapper.getWithLove(wrapper);
    }

    @Override
    public IPage pageUser(IPage page, QueryWrapper<User> wrapper) {
        return userMapper.pageUser(page,wrapper);
    }

    @Override
    public IPage pageNews(IPage page, QueryWrapper<User> wrapper) {
        return userMapper.pageNews(page,wrapper);
    }
}
