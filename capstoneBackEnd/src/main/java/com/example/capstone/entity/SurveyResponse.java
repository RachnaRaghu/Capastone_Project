package com.example.capstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue
    Long id;

    private Long createdOn;
    private String emailId;
    private String name;
    private Long surveyId;
    private String surveyName;
    private Long takenOn;
    private Long validTill;
    	
    @JoinTable(name = "response_qus_ans_mapping", joinColumns = @JoinColumn(name = "response_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
    @OneToMany(cascade = CascadeType.ALL)
    List<QuestionResponse> questionReposne;
   
   	public SurveyResponse() {
        super();
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getsurveyId() {
        return surveyId;
    }

    public void setsurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Long getTakenOn() {
        return takenOn;
    }

    public void setTakenOn(Long takenOn) {
        this.takenOn = takenOn;
    }

    public Long getValidTill() {
        return validTill;
    }

    public void setValidTill(Long validTill) {
        this.validTill = validTill;
    }

    public List<QuestionResponse> getQuestions() {
		return questionReposne;
	}

	public void setQuestions(List<QuestionResponse> questions) {
		this.questionReposne = questions;
	}


	@Override
	public String toString() {
		return "SurveyResponse [id=" + id + ", createdOn=" + createdOn + ", emailId=" + emailId + ", name=" + name
				+ ", surveyId=" + surveyId + ", surveyName=" + surveyName + ", takenOn=" + takenOn + ", validTill="
				+ validTill + ", questions=" + questionReposne + "]";
	}

  
	
}