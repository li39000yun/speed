package com.lyq.service.user.impl;

import com.lyq.dao.user.UserDao;
import com.lyq.model.user.UserEntity;
import com.lyq.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务层实现类
 * Created by 云强 on 2018/3/9.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(UserEntity user) {
        userDao.saveUser(user);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public UserEntity findUserById(String uuid) {
        return userDao.findUserById(uuid);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(String uuid) {
        userDao.deleteUserById(uuid);
    }

    @Override
    public List<UserEntity> findByPage(int skip, int limit) {
        return userDao.findByPage(skip, limit);
    }
}
