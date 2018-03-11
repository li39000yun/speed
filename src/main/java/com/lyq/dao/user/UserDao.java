package com.lyq.dao.user;

import com.lyq.model.user.UserEntity;

import java.util.List;

/**
 * 用户信息dao
 * Created by 云强 on 2018/3/9.
 */
public interface UserDao {
    public void insertAll(List<UserEntity> users);

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public void updateUser(UserEntity user);

    public void deleteUserById(String uuid);

    UserEntity findUserById(String uuid);

    List<UserEntity> findAll();

    /**
     * 分页查询
     *
     * @param skip  跳过多少条
     * @param limit 查多少条
     * @return
     */
    List<UserEntity> findByPage(int skip, int limit);
}
