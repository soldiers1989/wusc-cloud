package com.cxc.course.ret;

import java.util.List;

import com.cxc.course.model.CourseClass;

public class ClassContentRet extends CourseClass {
	private List<Object> children;

	public List<Object> getChildren() {
		return children;
	}

	public void setChildren(List<Object> children) {
		this.children = children;
	}
	

}
