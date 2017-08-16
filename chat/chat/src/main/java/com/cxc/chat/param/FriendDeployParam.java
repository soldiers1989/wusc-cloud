package com.cxc.chat.param;

import java.util.Date;

import com.cxc.anno.Required;

public class FriendDeployParam {
	@Required
	private Long userId;
	
	private String easeMobUserId;
	
	private Date deployTime;
	
	private String dynamicDepict;
	
	private String[] sharedPhotos;
	
	private boolean isPublic = true;
	
	private String type;

	private Float[] coordinates;
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDynamicDepict() {
		return dynamicDepict;
	}

	public void setDynamicDepict(String dynamicDepict) {
		this.dynamicDepict = dynamicDepict;
	}

	public String[] getSharedPhotos() {
		return sharedPhotos;
	}

	public void setSharedPhotos(String[] sharedPhotos) {
		this.sharedPhotos = sharedPhotos;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Float[] coordinates) {
		this.coordinates = coordinates;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}

	public String getEaseMobUserId() {
		return easeMobUserId;
	}

	public void setEaseMobUserId(String easeMobUserId) {
		this.easeMobUserId = easeMobUserId;
	}

}
