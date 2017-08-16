package com.cxc.course.param;

import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class TutorParam {

	@Required
	@StringLength(min=2, max=30)
    private String tutorName;
	@StringLength(min=0, max=1000)
    private String photoUrl;
	@StringLength(min=0, max=40)
    private String email;
	@Required
	@StringLength(min=0, max=2000)
    private String resume;

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
