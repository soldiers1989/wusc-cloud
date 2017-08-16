package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class ChapterParam {
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long courseId;
	@Required
	@StringLength(min=2, max=20)
    private String chapterName;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=0, max=2000)
    private String depict;
	@Required
	private Boolean isLeafNode;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	
}
