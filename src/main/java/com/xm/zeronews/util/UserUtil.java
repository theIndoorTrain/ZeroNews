package com.xm.zeronews.util;

import com.xm.zeronews.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
public class UserUtil {

    /**
     * 获取User
     * @return
     */
    public static User getUser() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = (User) currentUser.getPrincipal();
        return user;
    }

    /**
     * 获取UserId
     * @return
     */
    public static long getUserId() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = (User) currentUser.getPrincipal();
        return user.getId();
    }
}
