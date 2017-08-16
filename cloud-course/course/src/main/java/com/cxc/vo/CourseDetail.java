package com.cxc.vo;

import java.util.Date;
import java.util.List;

import com.cxc.course.model.Part;

public class CourseDetail {
	
	private Long courseId;

    private Integer categoryId;

    private String courseName;

    private String tutorId;

    private String depict;

    private String iconUrl;

    private String pictureUrl;

    private Boolean isLeafNode;

    private Date sn;
    
//    private Date created;

//    private Date updated;

//    private Long updateUserId;

//    private Short recommendedLevel;

    private Long clickRate;

    private Long participantsNum;

//    private Short attendanceGrade;

//    private Short exercisesGrade;

//    private Short examineGrade;

//    private Short passingGrade;

//    private String partIdList;

    private Short learningTargetNumber;
    
    //来自learning
    private float confCredit;
    
	private List<ChapterNode> chapterNodeList;
	private List<Part> partList;

	
	public CourseDetail(List<ChapterNode> chapterNodeList, List<Part> partList) {
		super();

		this.chapterNodeList = chapterNodeList;
		this.partList = partList;
	}
	
	public CourseDetail() {
		super();
	}
	

	public List<ChapterNode> getChapterNodeList() {
		return chapterNodeList;
	}
	public void setChapterNodeList(List<ChapterNode> chapterNodeList) {
		this.chapterNodeList = chapterNodeList;
	}

	public List<Part> getPartList() {
		return partList;
	}
	public void setPartList(List<Part> partList) {
		this.partList = partList;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

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

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public Date getSn() {
		return sn;
	}

	public void setSn(Date sn) {
		this.sn = sn;
	}

	public Long getClickRate() {
		return clickRate;
	}

	public void setClickRate(Long clickRate) {
		this.clickRate = clickRate;
	}

	public Long getParticipantsNum() {
		return participantsNum;
	}

	public void setParticipantsNum(Long participantsNum) {
		this.participantsNum = participantsNum;
	}

	public Short getLearningTargetNumber() {
		return learningTargetNumber;
	}

	public void setLearningTargetNumber(Short learningTargetNumber) {
		this.learningTargetNumber = learningTargetNumber;
	}

	public float getConfCredit() {
		return confCredit;
	}

	public void setConfCredit(float confCredit) {
		this.confCredit = confCredit;
	}


}

