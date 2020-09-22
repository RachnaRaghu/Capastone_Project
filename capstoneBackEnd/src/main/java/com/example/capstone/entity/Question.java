package com.example.capstone.entity;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    Long id;
    String question;
    String responseType;
    String validation;
    String options;
    Boolean isMandatory;
    
    public Question() {
        super();
    }

    public Question(String question, String responseType, String validation, String options, Boolean isMandatory) {
        this.question = question;
        this.responseType = responseType;
        this.validation = validation;
        this.options = options;
        this.isMandatory = isMandatory;
    }
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", isMandatory=" + isMandatory + ", options=" + options + ", question=" + question
                + ", responseType=" + responseType + ", validation=" + validation + "]";
    }
   
}
