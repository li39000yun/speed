package com.lyq.service.user;

import com.lyq.model.user.UserEntity;

import java.util.List;

/**
 * 用户信息service
 * Created by 云强 on 2018/3/9.
 */
public interface UserService {
    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public UserEntity findUserById(String uuid);

    public List<UserEntity> findAll();

    public void updateUser(UserEntity user);

    public void deleteUserById(String uuid);

    public List<UserEntity> findByPage(int skip, int limit);
}
