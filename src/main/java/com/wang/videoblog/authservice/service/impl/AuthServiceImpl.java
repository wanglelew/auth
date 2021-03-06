package com.wang.videoblog.authservice.service.impl;

import com.wang.videoblog.authservice.entity.User;
import com.wang.videoblog.authservice.mapper.UserMapper;
import com.wang.videoblog.authservice.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 王乐乐 WLL
 * @Classname AuthServiceImpl
 * @Describe:
 * @date 2021/3/6 11:17
 */
@Service(value = "AuthService")
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User auth(String username, String password) {
        User user = userMapper.findUserById(username, password);
        if (user==null) {
            throw new SecurityException("用户名或密码错误");
        }
        return user;
    }
}
