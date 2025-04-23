package com.sjj.ServiceTest;

import com.sjj.entity.Stu;
import com.sjj.service.StuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class servicetest {
    @Autowired
    private StuService stuService;
    @Test
    public void testFindAll(){
        for (Stu stu : stuService.findAll()) {
            System.out.println(stu);
        }
    }
    @Test
    public void testFindById(){
        Stu stu = stuService.findById(1);
        System.out.println(stu);
    }
    @Test
    public void testSave(){
        Stu stu = new Stu();
        stu.setGender("男");
        stu.setName("zcy");
        stu.setAge(18);
        stu.setId(5);
        stuService.save(stu);
    }
    @Test
    public void testUpdate(){
        Stu stu = new Stu();
        stu.setGender("男");
        stu.setName("sjj");
        stu.setAge(18);
        stu.setId(5);
        stuService.update(stu);
    }
    @Test
    public void testDelete(){
        stuService.delete(5);
    }
}
