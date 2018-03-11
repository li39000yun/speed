package com.lyq.controller.user;

import com.lyq.common.utils.UUIDUtils;
import com.lyq.model.user.UserEntity;
import com.lyq.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 用户信息控制类
 * Created by 云强 on 2018/3/8.
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 添加用户
     *
     * @param userName
     * @param passWord
     */
    @RequestMapping("/user/save")
    public void add(@RequestParam("userName") String userName,
                    @RequestParam("passWord") String passWord,
                    @RequestParam("loginId") String loginId,
                    @RequestParam("status") int status,
                    @RequestParam("uuid") String uuid) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassWord(passWord);
        userEntity.setStatus(status);
        userEntity.setLoginId(loginId);
        userEntity.setModifyTs(new Date());// 修改时间
        if (StringUtils.isEmpty(uuid)) {// uuid为空则新增，否则修改
            userEntity.setUuid(UUIDUtils.getUUID());
            userEntity.setCreateTs(new Date());// 创建时间
            userService.saveUser(userEntity);
        } else {
            userEntity.setUuid(uuid);
            userService.updateUser(userEntity);
        }
    }

    @RequestMapping("/user/get/{uuid}")
    public UserEntity userFindOne(@PathVariable("uuid") String uuid) {
        return userService.findUserById(uuid);
    }

    @RequestMapping("/user/getList")
    public List<UserEntity> userFindAll() {
        return userService.findAll();
    }

    @RequestMapping("/user/getListByPage")
    public List<UserEntity> userFindByPage(@PathVariable("skip") int skip, @PathVariable("limit") int limit) {
        return userService.findByPage(skip, limit);
    }

    @RequestMapping("/user/getByUserName/{userName}")
    public UserEntity userFindOneByUserName(@PathVariable("userName") String userName) {
        return userService.findUserByUserName(userName);
    }

}
