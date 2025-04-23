package com.sjj.dao;

import com.sjj.entity.Stu;

import java.util.List;



public interface StuDAO {

    //查询所有的方法
    List<Stu> findAll();

    //保存学生的方法
    void save(Stu emp);

    //删除学生的方法
    void delete(Integer id);

    //根据id查询学生信息
    Stu findById(Integer id);

    //更新学生信息
    void update(Stu stu);
}