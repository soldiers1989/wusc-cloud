package com.cxc.chat.model;

import java.util.Date;

public class UserRelation extends UserRelationKey {
	
	public static final byte TYPE_FRIEND = 0;//好友
	public static final byte TYPE_BLOCK = 1;//黑名单
	public static final byte TYPE_NONE = -1;//没有任何关系
	public static final byte TYPE_APPLY = 10;//好友申请中
	
    private Byte type;

    private String remark;

    private Date updated;

    private Date created;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}