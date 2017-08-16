package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class ChapterModifyParam {

	@Range(min=1, max=Long.MAX_VALUE)
	private Long courseId;
	@StringLength(min=2, max=50)
    private String chapterName;
	 @StringLength(min=0, max=1000)
    private String pictureUrl;
    @StringLength(min=0, max=2000)
    private String depict;
	private Boolean isLeafNode;
	@StringLength(min=0, max=100)
	private String partIdList;
    
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

	public String getPartIdList() {
		return partIdList;
	}

	public void setPartIdList(String partIdList) {
		this.partIdList = partIdList;
	}
	
}
