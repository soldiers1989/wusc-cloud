package com.cxc.vo;

import java.util.ArrayList;
import java.util.List;

import com.cxc.course.model.Course;
import com.cxc.course.model.CourseCategory;

public class MainPageData {
	List<Course> specialCourse=new ArrayList<>();
	List<CourseCategory> courseCategory=new ArrayList<>();
	List<Course> recommendCourse=new ArrayList<>();
	
	public List<Course> getSpecialCourse() {
		return specialCourse;
	}
	public void setSpecialCourse(List<Course> specialCourse) {
		this.specialCourse = specialCourse;
	}
	public List<CourseCategory> getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(List<CourseCategory> courseCategory) {
		this.courseCategory = courseCategory;
	}
	public List<Course> getRecommendCourse() {
		return recommendCourse;
	}
	public void setRecommendCourse(List<Course> recommendCourse) {
		this.recommendCourse = recommendCourse;
	}
}
