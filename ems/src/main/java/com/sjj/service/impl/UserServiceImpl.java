package com.sjj.service.impl;

import com.sjj.dao.UserDAO;
import com.sjj.entity.User;
import com.sjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username,password);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }
}
