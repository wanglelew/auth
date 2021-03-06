package com.wang.videoblog.authservice.mapper;

import com.sun.tracing.dtrace.ModuleAttributes;
import com.wang.videoblog.authservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 王乐乐 WLL
 * @Classname userMapper
 * @Describe:
 * @date 2021/3/6 10:57
 */

public interface UserMapper {

    public User findUserById(@Param("u") String usernmae,@Param("p") String password );
}
