package com.cxc.chat.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cxc.chat.constants.MongoDbCollection;

@Document(collection=MongoDbCollection.USER_EXTEND_INFO_COLLECTION)  
public class UserExtendInfo extends UserBasicInfo{
	@Field("school_id")
    private Long shcoolId;
    
    @Field("entry_course")
    private Long[] entryCouse;
     
    @Field("loc")
    private LocationInfo locationInfo;
    
    public LocationInfo getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}

	public Long getShcoolId() {
		return shcoolId;
	}

	public void setShcoolId(Long shcoolId) {
		this.shcoolId = shcoolId;
	}

	public Long[] getEntryCouse() {
		return entryCouse;
	}

	public void setEntryCouse(Long[] entryCouse) {
		this.entryCouse = entryCouse;
	}

}
