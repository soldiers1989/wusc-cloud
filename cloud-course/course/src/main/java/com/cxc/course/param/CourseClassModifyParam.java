package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class CourseClassModifyParam {

	@StringLength(min=2, max=50)
    private String className;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
    @StringLength(min=0, max=2000)
    private String depict;
    @Range(min=0, max=Short.MAX_VALUE)
	private Short isLeafNode;
    
	public Short getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Short isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	
    
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

}
