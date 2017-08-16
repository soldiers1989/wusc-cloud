package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class CourseParam {

	@Range(min=1, max=Integer.MAX_VALUE)
	@Required
	private Integer categoryId;
	@Required
	@StringLength(min=2, max=50)
    private String courseName;
	@StringLength(min=0, max=40)
    private String tutorId;
	@StringLength(min=0, max=2000)
    private String depict;
	@StringLength(min=0, max=1000)
    private String iconUrl;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@Range(min=0, max=Short.MAX_VALUE)
    private Short recommendedLevel;
	@Required
	private Boolean isLeafNode;
	@Required
	@Range(min=1, max=Short.MAX_VALUE)
	private Short learningTargetNumber;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Short getRecommendedLevel() {
		return recommendedLevel;
	}

	public void setRecommendedLevel(Short recommendedLevel) {
		this.recommendedLevel = recommendedLevel;
	}

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}
	
	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	public Short getLearningTargetNumber() {
		return learningTargetNumber;
	}

	public void setLearningTargetNumber(Short learningTargetNumber) {
		this.learningTargetNumber = learningTargetNumber;
	}
}
