package com.lyq.dao.user.impl;

import com.lyq.dao.user.UserDao;
import com.lyq.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户信息实体类
 * Created by 云强 on 2018/3/9.
 */
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertAll(List<UserEntity> users) {
        mongoTemplate.insertAll(users);
    }

    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    @Override
    public void updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("uuid").is(user.getUuid()));
        Update update = new Update().set("userName", user.getUserName())
                .set("passWord", user.getPassWord())
                .set("loginId",user.getLoginId())
                .set("status",user.getStatus());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    @Override
    public void deleteUserById(String uuid) {
        Query query = new Query(Criteria.where("uuid").is(uuid));
        mongoTemplate.remove(query, UserEntity.class);
    }

    @Override
    public UserEntity findUserById(String uuid) {
        Query query = new Query(Criteria.where("uuid").is(uuid));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class);
    }

    @Override
    public List<UserEntity> findByPage(int skip, int limit) {
        Query query = new Query();
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, UserEntity.class);
    }
}
