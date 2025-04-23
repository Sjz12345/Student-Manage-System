package com.sjj.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class User {
    private Integer id;			// 序号
    private String username;	// 用户姓名
    private String password;	// 用户密码
}