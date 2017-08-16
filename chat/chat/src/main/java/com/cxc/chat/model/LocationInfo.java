package com.cxc.chat.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document  
public class LocationInfo {
	@Field("type")
	private String type;

	@Field("coordinates")
	private Float[] coordinates;
	
	public LocationInfo(){
		
	}
	
	public LocationInfo(String type, Float longitude, Float latitude){
		this.type = type;
		this.coordinates = new Float[2];
		this.coordinates[0] = longitude;
		this.coordinates[1] = latitude;
	}
	
	public LocationInfo(String type, Float[] coordinates){
		this.type = type;
		this.coordinates = coordinates;
	}

	public Float[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Float[] coordinates) {
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
