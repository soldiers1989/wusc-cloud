package com.cxc.chat.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cxc.chat.constants.MongoDbCollection;

@Document(collection=MongoDbCollection.FRIENDS_DYNAMIC_INFO_COLLECTION)
public class FriendsDynamicInfo extends UserBasicInfo{

	@Field("_id")
	private String messageId;
	
	@Field("ease_mob_user_id")
	private String easeMobUserId;
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Field("dynamic_depict")
	private String dynamicDepict;
	
	@Field("shared_photos")
	private String[] sharedPhotos;
	
	@Field("deploy_time")
	private Date deployTime;
	
	@Field("is_public")
	private boolean isPublic;
	
	@Field("work_loc")
	private LocationInfo workLocation;
	
	@Field("current_loc")
	private LocationInfo currentLocation;
	
	@Field("thumbs_up")
	private List<UserBasicInfo> thumbsUp;
	
	@Field("reply")
	private List<CommentInfo> reply;

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


	public LocationInfo getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(LocationInfo workLocation) {
		this.workLocation = workLocation;
	}

	public LocationInfo getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(LocationInfo currentLocation) {
		this.currentLocation = currentLocation;
	}

	public List<UserBasicInfo> getThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(List<UserBasicInfo> thumbsUp) {
		this.thumbsUp = thumbsUp;
	}


	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}

	public List<CommentInfo> getReply() {
		return reply;
	}

	public void setReply(List<CommentInfo> reply) {
		this.reply = reply;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getEaseMobUserId() {
		return easeMobUserId;
	}

	public void setEaseMobUserId(String easeMobUserId) {
		this.easeMobUserId = easeMobUserId;
	}

}
