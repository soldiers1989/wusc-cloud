package com.cxc.chat.easemob.model;

import java.util.Date;

import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class ChatUser {
	private String uuid;
	private String type;
	private Date created;
	private Date modified;
	@Required
	@StringLength(min=1, max=11)
	private String username;
	@Required
	@StringLength(min=1, max=11)
	private String password;
	private Boolean activated;
	private String nickname;
	private Integer notification_display_style;
	private Boolean notification_no_disturbing;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getNotification_display_style() {
		return notification_display_style;
	}
	public void setNotification_display_style(Integer notification_display_style) {
		this.notification_display_style = notification_display_style;
	}
	public Boolean getNotification_no_disturbing() {
		return notification_no_disturbing;
	}
	public void setNotification_no_disturbing(Boolean notification_no_disturbing) {
		this.notification_no_disturbing = notification_no_disturbing;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
