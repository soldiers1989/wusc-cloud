package com.cxc.vo;

import java.util.List;

import com.cxc.course.model.Course;

public class CourseListData extends DataWrap<List<Course>> {

	public CourseListData() {
		super();
	}

	public CourseListData(List<Course> data) {
		super(data);
	}
}
