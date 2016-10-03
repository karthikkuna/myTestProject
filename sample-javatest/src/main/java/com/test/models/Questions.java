package com.test.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Questions implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String questionKey;
	private String questionName;
	private Date createdDate;
	private int questionSid;
	
	private Set <Answers> answers ;
	
	public String getQuestionKey() {
		return questionKey;
	}
	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getQuestionSid() {
		return questionSid;
	}
	public void setQuestionSid(int questionSid) {
		this.questionSid = questionSid;
	}
	public Set <Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(Set <Answers> answers) {
		this.answers = answers;
	}	

}
