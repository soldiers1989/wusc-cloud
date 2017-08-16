package com.cxc.vo;

import java.util.List;
import com.cxc.course.model.CourseCategory;

public class CourseCategoryListData extends DataWrap<List<CourseCategory>>{
	public CourseCategoryListData() {
		super();
	}

	public CourseCategoryListData(List<CourseCategory> data) {
		super(data);
	}
}
