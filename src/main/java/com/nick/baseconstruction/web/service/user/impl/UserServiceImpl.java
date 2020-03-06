package com.nick.baseconstruction.web.service.user.impl;

import com.nick.baseconstruction.web.dao.UserDao;
import com.nick.baseconstruction.web.entity.User;
import com.nick.baseconstruction.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}
