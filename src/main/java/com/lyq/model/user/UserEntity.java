package com.lyq.model.user;

import com.lyq.model.common.BaseEntity;

import java.util.Date;

/**
 * 用户信息
 * Created by 云强 on 2018/3/9.
 */
public class UserEntity extends BaseEntity {

    private String userName;// 用户名
    private String passWord;// 密码
    private String loginId;// 登录账号
    private Date lastLoginTs;// 最后登录时间

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getLastLoginTs() {
        return lastLoginTs;
    }

    public void setLastLoginTs(Date lastLoginTs) {
        this.lastLoginTs = lastLoginTs;
    }
}
