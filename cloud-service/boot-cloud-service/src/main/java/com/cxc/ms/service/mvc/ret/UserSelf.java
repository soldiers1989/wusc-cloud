/**
 * 
 */
package com.cxc.ms.service.mvc.ret;

import com.cxc.ms.service.mvc.model.User;

/**
 * <pre>
 * 用户资料（自己查看）
 * @author Leo
 * </pre>
 */
public class UserSelf extends User{
	private String organizationName;
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
}
