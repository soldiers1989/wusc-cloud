package com.cxc.vo;

import java.util.List;

import com.cxc.course.model.CourseComment;
import com.cxc.course.model.Tutor;

public class CourseDetailPageData {
	CourseDetail courseDetail;
	List<Tutor> tutorList;
	Float credit;
	List<CourseComment> courseCommentList;
	Boolean isJoin=false;
	Boolean isCollected=false;
	int courseCommentNum=0;
	
	public CourseDetail getCourseDetail() {
		return courseDetail;
	}
	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}
	public List<Tutor> getTutorList() {
		return tutorList;
	}
	public void setTutorList(List<Tutor> tutorList) {
		this.tutorList = tutorList;
	}
	public Float getCredit() {
		return credit;
	}
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	public List<CourseComment> getCourseCommentList() {
		return courseCommentList;
	}
	public void setCourseCommentList(List<CourseComment> courseCommentList) {
		this.courseCommentList = courseCommentList;
	}
	public Boolean getIsJoin() {
		return isJoin;
	}
	public void setIsJoin(Boolean isJoin) {
		this.isJoin = isJoin;
	}
	public int getCourseCommentNum() {
		return courseCommentNum;
	}
	public void setCourseCommentNum(int courseCommentNum) {
		this.courseCommentNum = courseCommentNum;
	}
	public Boolean getIsCollected() {
		return isCollected;
	}
	public void setIsCollected(Boolean isCollected) {
		this.isCollected = isCollected;
	}
}
