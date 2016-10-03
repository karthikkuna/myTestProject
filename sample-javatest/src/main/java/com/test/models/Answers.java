package com.test.models;

import java.io.Serializable;
import java.util.Date;

public class Answers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String answerValue;

	private int answersSid;

	public String getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}

	public int getAnswersSid() {
		return answersSid;
	}

	public void setAnswersSid(int answersSid) {
		this.answersSid = answersSid;
	}

		
	

}
