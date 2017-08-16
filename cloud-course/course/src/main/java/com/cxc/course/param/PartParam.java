package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class PartParam {
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long courseId;
	@Range(min=0, max=Long.MAX_VALUE)
	@Required
	private Long chapterId;
	@Range(min=0, max=Long.MAX_VALUE)
	//@Required
	private Long sectionId;
	@Range(min=0, max=Long.MAX_VALUE)
	//@Required
	private Long unitId;
	@Required
	@StringLength(min=0, max=50)
    private String partName;
	@Required
	@Range(min=0, max=Short.MAX_VALUE)
    private Short partType;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=0, max=2000)
    private String depict;
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long resourceId;
	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	
	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}
	
	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Short getPartType() {
		return partType;
	}

	public void setPartType(Short partType) {
		this.partType = partType;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}
	
	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}
