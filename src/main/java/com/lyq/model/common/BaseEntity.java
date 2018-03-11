package com.lyq.model.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基础类
 * Created by 云强 on 2018/3/9.
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String uuid;// id
    protected int status = 1;// 状态（1：正常；0：删除）
    protected String creator;//创建人
    protected Date createTs;//创建时间戳
    protected String modifier;//修改人
    protected Date modifyTs;// 修改时间戳

    public BaseEntity() {
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(Date modifyTs) {
        this.modifyTs = modifyTs;
    }
}
