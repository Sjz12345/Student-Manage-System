package com.sjj.service;
import com.sjj.entity.Stu;
import java.util.List;

public interface StuService {
    //查询所有的方法
    List<Stu> findAll();

    //保存学生的方法
    void save(Stu stu);

    //删除学生的方法
    void delete(Integer id);

    //根据id查询学生信息
    Stu findById(Integer id);

    //更新学生信息的方法
    void update(Stu stu);
}