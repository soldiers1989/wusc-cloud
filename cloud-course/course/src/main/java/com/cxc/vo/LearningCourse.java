package com.cxc.vo;

import java.util.Date;

public class LearningCourse {
	//course部分
	private Long courseId;

//    private Integer categoryId;

    private String courseName;

//    private String tutorId;

//    private String depict;

//    private String iconUrl;

    private String pictureUrl="";

//    private Date created;

//    private Date updated;

//    private Long updateUserId;

//    private Short recommendedLevel;

//    private Long clickRate;

//    private Long participantsNum;

    private Short attendanceGrade=0;

    private Short exercisesGrade=0;

    private Short examineGrade=0;

    private Short passingGrade=0;

//    private Boolean isLeafNode;

//    private String partIdList;

    private Date sn;
    
    private Short learningTargetNumber=0;
    
    //learning部分
    private Long learningId;

//    private Long userId;

//    private Long courseId;

    private Boolean isCollection;

    private Boolean isJoin;

    private Long favoritesId;

//    private Float credit;

//    private String progressRecord;

//    private Date collectTime;

//    private Date joinTime;

//    private Date updated;

    private Short status=0;

    private Short progress=0;

    private Float grade=0f;

    private Short evaluate=0;
    
    private Float confCredit=0f;
    
    //增加的
    private Short singInNum=0;



	public Short getSingInNum() {
		return singInNum;
	}

	public void setSingInNum(Short singInNum) {
		this.singInNum = singInNum;
	}

	public Float getConfCredit() {
		return confCredit;
	}

	public void setConfCredit(Float confCredit) {
		this.confCredit = confCredit;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Short getAttendanceGrade() {
		return attendanceGrade;
	}

	public void setAttendanceGrade(Short attendanceGrade) {
		this.attendanceGrade = attendanceGrade;
	}

	public Short getExercisesGrade() {
		return exercisesGrade;
	}

	public void setExercisesGrade(Short exercisesGrade) {
		this.exercisesGrade = exercisesGrade;
	}

	public Short getExamineGrade() {
		return examineGrade;
	}

	public void setExamineGrade(Short examineGrade) {
		this.examineGrade = examineGrade;
	}

	public Short getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(Short passingGrade) {
		this.passingGrade = passingGrade;
	}

	public Date getSn() {
		return sn;
	}

	public void setSn(Date sn) {
		this.sn = sn;
	}

	public Long getLearningId() {
		return learningId;
	}

	public void setLearningId(Long learningId) {
		this.learningId = learningId;
	}

	public Boolean getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Boolean isCollection) {
		this.isCollection = isCollection;
	}

	public Boolean getIsJoin() {
		return isJoin;
	}

	public void setIsJoin(Boolean isJoin) {
		this.isJoin = isJoin;
	}

	public Long getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(Long favoritesId) {
		this.favoritesId = favoritesId;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public Short getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(Short evaluate) {
		this.evaluate = evaluate;
	}

	public Short getLearningTargetNumber() {
		return learningTargetNumber;
	}

	public void setLearningTargetNumber(Short learningTargetNumber) {
		this.learningTargetNumber = learningTargetNumber;
	}
    
    
}
