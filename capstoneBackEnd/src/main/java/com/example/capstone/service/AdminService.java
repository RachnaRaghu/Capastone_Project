package com.example.capstone.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.Survey;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.entity.User;
import com.example.capstone.repo.SurveyRepo;
import com.example.capstone.repo.SurveyResponseRepo;
import com.example.capstone.repo.UserRepo;

@Service
public class AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
    UserRepo userRepo;

	@Autowired
    SurveyRepo surveyRepo;
    
	@Autowired
    SurveyResponseRepo surveyResponseRepo;

    public ResponseObject saveSurvey( Survey survey) {
        LOGGER.info("Saving Survey {}", survey);
        Survey savedData = surveyRepo.save(survey);
        LOGGER.info("Survey saved");
        return new ResponseObject(true, savedData);
    }

    public ResponseObject getAllSurveys() {

        updateSurveyStatus();
        LOGGER.info("Fetching all surveys");
        List<Survey> allSurveys = (List<Survey>) surveyRepo.findAll();
        LOGGER.info("All Surveys {}", allSurveys);
        return new ResponseObject(true, allSurveys);
    }

    public ResponseObject login(User user) {
        LOGGER.info("Authenticating user {}", user.getUserName());
        ResponseObject response;
        User result = userRepo.findByEmailAndPassword(user.getUserName(), user.getPassword());
        if (result == null) {
            response = new ResponseObject(false, "Invalid credentials");
        } else {
            response = new ResponseObject(true, "Success");
        }
        LOGGER.info("Authentication result {}", response);
        return response;
    }

    public ResponseObject launchSurvey(int surveyId) {

        LOGGER.info("Publishing survey {}", surveyId);
        Survey updatedSurvey = surveyRepo.findById(surveyId).orElse(null);      
	     updatedSurvey.setStatus("PUBLISHED");
        surveyRepo.save(updatedSurvey);
        LOGGER.info("Published survey {}", surveyId);
        return new ResponseObject(true, updatedSurvey);
    }

    public ResponseObject getSurvey(int surveyId) {

        ResponseObject response;
        Survey foundSurvey = surveyRepo.findById(surveyId).orElse(null);
        if (foundSurvey == null) {
            response = new ResponseObject(false, "Invalid surveyId");
        } else {
            response = new ResponseObject(true, foundSurvey);
        }
        return response;
    }

    public ResponseObject deleteSurvey(int surveyId) {

        ResponseObject response = new ResponseObject(true, "Survey Deleted Successfully");;
        surveyRepo.deleteById(surveyId);
        return response;
    }

    public ResponseObject getPublishedSurveys() {

        LOGGER.info("Fetching published surveys");
        List<Survey> publishedSurveys = surveyRepo.findAllPublishedSurveys();
        LOGGER.info("All published Surveys {}", publishedSurveys);
        return new ResponseObject(true, publishedSurveys);
    }

    public void updateSurveyStatus() {

        LOGGER.info("Checking and updating survey status if any survey expired");
        Long currentTime = new Date().getTime();
        int updatedSurveys = surveyRepo.updateStatus(currentTime);
        LOGGER.info("Updated survey {}", updatedSurveys);

    }

    public ResponseObject createUser(User user) {

        LOGGER.info("Creating new user {}", user.getUserName());
        ResponseObject response;
        if (login(user).getResult()) {
            response = new ResponseObject(false, "Username already exists");
        } else {
            
			userRepo.save(user);
            response = new ResponseObject(true, "User created successfully");
        }
        LOGGER.info("Created new user {}", user.getUserName());
        return response;
    }

    public ResponseObject getSurveysForAnalysis() {

        LOGGER.info("Getting surveys for analysis");
        ResponseObject response;
        List<Survey> surveysForAnalysis = surveyRepo.findSurveysForAnalysis();
        response = new ResponseObject(true, surveysForAnalysis);
        System.out.println("List of survey "+surveysForAnalysis);
        LOGGER.info("Surveys for analysis {}", surveysForAnalysis);
        return response;
    }

    public ResponseObject getSurveyResponses(Long surveyId, Long from, Long to) {

        LOGGER.info("getting survey responses {} {} {}", surveyId, from, to);
        ResponseObject response;
        List<SurveyResponse> surveysForAnalysis;
        if(surveyId==null) {
            surveysForAnalysis = surveyResponseRepo.findByDateRange(from, to);
        }
         else if (from == null && to == null) {
            surveysForAnalysis = surveyResponseRepo.findBySurveyId(surveyId);
        } else if (to == null) {
            surveysForAnalysis = surveyResponseRepo.findByDateFrom(surveyId, from);
        } else if (from != null && to != null) {
            surveysForAnalysis = surveyResponseRepo.findByAll(surveyId, from, to);
        }        
        else {
            surveysForAnalysis = surveyResponseRepo.findByDateTo(surveyId, to);
        }
        response = new ResponseObject(true, surveysForAnalysis);
        LOGGER.info("Survey responses {}", surveysForAnalysis);
        return response;
    }

    public ResponseObject getSurveyResponsesForChart() {

    	 List<Survey> surveysForAnalysis = surveyRepo.findSurveysForAnalysis();
         LinkedHashMap<String, Object> surveys = new LinkedHashMap<String, Object>();
         for (Survey survey: surveysForAnalysis) {
             LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
             data.put("name", survey.getSurveyName());
             data.put("noOfQuestions", survey.getQuestions().size());
             data.put("noOfResponses", surveyResponseRepo.findBySurveyId(survey.getId()).size());
             data.put("createdOn", survey.getCreatedOn());
             data.put("validTill", survey.getValidTill());
             surveys.put(survey.getSurveyName(), data);
         }
         return new ResponseObject(true, surveys);
        
    }
}