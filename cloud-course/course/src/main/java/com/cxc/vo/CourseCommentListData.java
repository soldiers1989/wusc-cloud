package com.cxc.vo;

import java.util.List;

import com.cxc.course.model.CourseComment;

public class CourseCommentListData  extends DataWrap<List<CourseComment>> {

	public CourseCommentListData() {
		super();
	}

	public CourseCommentListData(List<CourseComment> data) {
		super(data);
	}
}
