package com.xm.zeronews.config;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.zeronews.dao.UserMapper;
import com.xm.zeronews.pojo.User;
import com.xm.zeronews.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    public MyRealm(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String str = usernamePasswordToken.getUsername();
        String[] strs = str.split(",");
        User user = null;
        try {

            user = userService.getOne(new QueryWrapper<User>().eq("email", strs[0]).eq("type",strs[1]).eq("isActive",true));

        }catch(Exception e) {
            e.printStackTrace();
        }

        String password = new String(usernamePasswordToken.getPassword());
        if(user.getPassword().equals(password)) {
            return new SimpleAuthenticationInfo(user,password,getName());
        } else {
            throw new AccountException("帐号或密码不正确！");
        }
    }

}
