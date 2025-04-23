package com.sjj.service;
import com.sjj.entity.User;

public interface UserService {
    //保存用户，即用户注册
    void save(User user);
    //登录，即用户查询，判断有无
    User login(String username,String password);
}