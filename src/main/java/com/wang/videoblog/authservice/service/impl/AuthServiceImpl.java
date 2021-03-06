package com.wang.videoblog.authservice.service.impl;

import com.wang.videoblog.authservice.entity.User;
import com.wang.videoblog.authservice.mapper.UserMapper;
import com.wang.videoblog.authservice.service.AuthService;

import javax.annotation.Resource;

/**
 * @author 王乐乐 WLL
 * @Classname AuthServiceImpl
 * @Describe:
 * @date 2021/3/6 11:17
 */
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User auth(String username, String password) {
        return userMapper.findUserById(username,password);
    }
}
