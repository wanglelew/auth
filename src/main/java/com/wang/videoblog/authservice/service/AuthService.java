package com.wang.videoblog.authservice.service;

import com.wang.videoblog.authservice.entity.User;

/**
 * @author 王乐乐 WLL
 * @Classname AuthService
 * @Describe:
 * @date 2021/3/6 11:15
 */
public interface AuthService {
    public User auth(String username,String password);
}
