package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class SubjectiveTestParam {
	
	@Range(min=1, max=Long.MAX_VALUE)
	@Required
	private Long partId;
	@StringLength(min=5, max=2000)
	@Required
	private String referenceMaterial;
	@Required
	@StringLength(min=5, max=1000)
    private String questions;
	@Range(min=0, max=Short.MAX_VALUE)
	@Required
	private Short score;
	@StringLength(min=0, max=2000)
    private String commentOn;

	
	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public String getReferenceMaterial() {
		return referenceMaterial;
	}

	public void setReferenceMaterial(String referenceMaterial) {
		this.referenceMaterial = referenceMaterial;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Short getScore() {
		return score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

	public String getCommentOn() {
		return commentOn;
	}
	public void setCommentOn(String commentOn) {
		this.commentOn = commentOn;
	}
	
}
