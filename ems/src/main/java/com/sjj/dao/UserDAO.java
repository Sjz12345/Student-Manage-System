package com.sjj.dao;

import com.sjj.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface UserDAO {

    //保存用户的方法
    void save(User user);

    //登录的方法，如果不注解参数，xml找不到参数名
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}