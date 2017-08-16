package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class CourseCommentModifyParam {
	
	@Range(min=1, max=Long.MAX_VALUE)
	private Long courseId;
	@Range(min=1, max=Long.MAX_VALUE)
	private Long userId;
	@StringLength(min=2, max=100)
    private String title;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=5, max=2000)
    private String conntent;
	@StringLength(min=0, max=1000)
    private String underwrite;
	@StringLength(min=0, max=20)
    private String nickname;
	@StringLength(min=0, max=1000)
    private String photoUrl;
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}

