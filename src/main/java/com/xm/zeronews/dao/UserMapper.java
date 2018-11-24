package com.xm.zeronews.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-14
 */
public interface UserMapper extends BaseMapper<User> {

    User getWithLove(@Param("ew") QueryWrapper<User> wrapper);

    IPage pageUser(IPage page,@Param("ew") QueryWrapper<User> wrapper);

    IPage pageNews(IPage page,@Param("ew") QueryWrapper<User> wrapper);
}
