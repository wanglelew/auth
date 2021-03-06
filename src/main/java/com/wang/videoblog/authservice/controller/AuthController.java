package com.wang.videoblog.authservice.controller;

import com.wang.videoblog.authservice.dto.ResultVo;
import com.wang.videoblog.authservice.entity.User;
import com.wang.videoblog.authservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 王乐乐 WLL
 * @Classname AuthController
 * @Describe:
 * @date 2021/3/6 11:30
 */
@RestController
public class AuthController {
    @Resource
    private AuthService authService;

    @PostMapping("/auth")
    public ResultVo<Map> auth(String username,String password){
         ResultVo<Map> result=null;
         try {
             User user = authService.auth(username, password);
             Map data=new LinkedHashMap();
             data.put("user",user);
             result=new ResultVo<>(data);
         }catch (Exception e){
             e.printStackTrace();
             result=new ResultVo<>(e.getClass().getSimpleName(),e.getMessage());
         }

         return result;

    }
}
