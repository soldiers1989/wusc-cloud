package com.cxc.course.ret;

import java.util.List;

import com.cxc.course.model.Chapter;

public class ChapterContentRet extends Chapter{
	private List<Object> children;
	public List<Object> getChildren() {
		return children;
	}
	public void setChildren(List<Object> children) {
		this.children = children;
	}
}
