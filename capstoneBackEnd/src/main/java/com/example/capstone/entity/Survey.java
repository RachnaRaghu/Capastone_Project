package com.example.capstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Survey {

	@Id
	@GeneratedValue
    private int id;
	private String surveyTitle;
	private String description;
	private String status;
	private String surveyName;
	private long createdOn;
	private long validTill;
	private long surveyExpiresOn;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "survey_question_mapping", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;

	public Survey() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public long getValidTill() {
		return validTill;
	}

	public void setValidTill(long validTill) {
		this.validTill = validTill;
	}

	public long getSurveyExpiresOn() {
		return surveyExpiresOn;
	}

	public void setSurveyExpiresOn(long surveyExpiresOn) {
		this.surveyExpiresOn = surveyExpiresOn;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", surveyTitle=" + surveyTitle + ", description=" + description + ", status="
				+ status + ", surveyName=" + surveyName + ", createdOn=" + createdOn + ", validTill=" + validTill
				+ ", surveyExpiresOn=" + surveyExpiresOn + ", questions=" + questions + "]";
	}

	
	
	

}