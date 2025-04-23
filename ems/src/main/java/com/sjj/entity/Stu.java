package com.sjj.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Stu {
    private Integer id;		// 编号
    private String name;	// 姓名
    private String gender;	// 性别
    private Integer age;	// 年龄
}