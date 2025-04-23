package com.sjj.service.impl;

import com.sjj.dao.StuDAO;
import com.sjj.entity.Stu;
import com.sjj.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDAO stuDAO;

    @Override
    public void update(Stu emp) {
        stuDAO.update(emp);
    }

    @Override
    public Stu findById(Integer id) {
        return stuDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        stuDAO.delete(id);
    }

    @Override
    public void save(Stu emp) {
        stuDAO.save(emp);
    }

    @Override
    public List<Stu> findAll() {
        return stuDAO.findAll();
    }
}
