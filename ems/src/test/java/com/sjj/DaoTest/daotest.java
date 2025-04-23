package com.sjj.DaoTest;

import com.sjj.dao.StuDAO;
import com.sjj.entity.Stu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class daotest {

    @Autowired
    private StuDAO studao;
    @Test
    public void testQuetyAll(){
        List<Stu> all = studao.findAll();
        for(Stu stu : all){
            System.out.println(stu);
        }
    }
    @Test
    public void testQueryById(){
        Stu stu = studao.findById(1);
        System.out.println(stu);
    }
    @Test
    public void testDel(){
        studao.delete(6);
    }
    @Test
    public void testUpd(){
        Stu stu = new Stu();
        stu.setId(1);
        stu.setName("郑丰华");
        stu.setAge(18);
        stu.setGender("女");
        studao.update(stu);
    }
}
