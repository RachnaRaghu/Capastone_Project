package com.example.capstone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class QuestionResponse {

	@Id
	@GeneratedValue
	private Long id;
	private String question;
    private Boolean isMandatory;
    private String answer;
    
    
	public QuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionResponse(Long id, String question, Boolean isMandatory, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.isMandatory = isMandatory;
		this.answer = answer;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Boolean getIsMandatory() {
		return isMandatory;
	}


	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "QuestionAnswer [id=" + id + ", question=" + question + ", isMandatory=" + isMandatory + ", answer="
				+ answer + "]";
	}
	
	
    
    
}
