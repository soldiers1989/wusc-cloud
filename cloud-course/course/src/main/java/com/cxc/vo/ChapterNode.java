package com.cxc.vo;

import java.util.Date;
import java.util.List;

public class ChapterNode{
	List<SectionNode> sectionNodeList;
	private List<PartNode> partList;
	
	private Long chapterId;

    private Long courseId;

    private String chapterName;

    private String pictureUrl;

    private String depict;

    private Date sn;

    private Boolean isLeafNode;

	public ChapterNode(List<SectionNode> sectionNodeList, List<PartNode> partList) {
		super();

		this.sectionNodeList = sectionNodeList;
		this.partList = partList;
	}
	
	public ChapterNode() {
		super();
	}
	
	public List<SectionNode> getSectionNodeList() {
		return sectionNodeList;
	}
	public void setSectionNodeList(List<SectionNode> sectionNodeList) {
		this.sectionNodeList = sectionNodeList;
	}
	
	public List<PartNode> getPartList() {
		return partList;
	}
	public void setPartList(List<PartNode> partList) {
		this.partList = partList;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

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

	public Date getSn() {
		return sn;
	}

	public void setSn(Date sn) {
		this.sn = sn;
	}

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

}

