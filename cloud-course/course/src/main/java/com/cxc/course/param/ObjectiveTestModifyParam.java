package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class ObjectiveTestModifyParam {
	
	@Range(min=1, max=Long.MAX_VALUE)
	private Long partId;
	@Range(min=0, max=Short.MAX_VALUE)
	private Short questionType;
	@StringLength(min=5, max=1000)
    private String question;
	@StringLength(min=5, max=1000)
    private String choices;
	@StringLength(min=1, max=10)
    private String rightKey;
	@Range(min=0, max=Short.MAX_VALUE)
	private Short score;
	@StringLength(min=0, max=2000)
    private String commentOn;
    
    
	public Long getPartId() {
		return partId;
	}
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	public Short getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Short questionType) {
		this.questionType = questionType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoices() {
		return choices;
	}
	public void setChoices(String choices) {
		this.choices = choices;
	}
	public String getRightKey() {
		return rightKey;
	}
	public void setRightKey(String rightKey) {
		this.rightKey = rightKey;
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
