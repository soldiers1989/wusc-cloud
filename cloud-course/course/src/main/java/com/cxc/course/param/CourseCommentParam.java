package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class CourseCommentParam {
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long courseId;
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long userId;
	@Required
	@StringLength(min=2, max=100)
    private String title;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=5, max=2000)
	@Required
    private String conntent;
	@StringLength(min=0, max=1000)
    private String underwrite;
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getConntent() {
		return conntent;
	}
	public void setConntent(String conntent) {
		this.conntent = conntent;
	}
	public String getUnderwrite() {
		return underwrite;
	}
	public void setUnderwrite(String underwrite) {
		this.underwrite = underwrite;
	}
	
	

}
