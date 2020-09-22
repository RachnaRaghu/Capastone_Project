package com.example.capstone.contoller;

import java.util.Map;

import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.Survey;
import com.example.capstone.entity.User;
import com.example.capstone.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseObject createUser(@RequestBody User user) {

        return adminService.createUser(user);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseObject login(@RequestBody User user) {
        
        return adminService.login(user);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public ResponseObject saveSurvey(@RequestBody Survey survey) {

            return adminService.saveSurvey(survey);
        
    }

    @RequestMapping(value = "/getAllSurveys", method = RequestMethod.GET)
    public ResponseObject getAllSurveys() {

        return adminService.getAllSurveys();
    }

    @RequestMapping(value = "/launchSurvey", method = RequestMethod.PUT)
    public ResponseObject launchSurvey(@RequestBody Map<String, Integer> surveyId) {

        return adminService.launchSurvey(surveyId.get("id"));
    }

    @RequestMapping(value = "/getSurvey/{surveyId}", method = RequestMethod.GET)
    public ResponseObject getSurvey(@PathVariable("surveyId") int surveyId) {

        return adminService.getSurvey(surveyId);
    }

    @RequestMapping(value = "/deleteSurvey/{surveyId}", method = RequestMethod.DELETE)
    public ResponseObject deleteSurvey(@PathVariable("surveyId") int surveyId) {

        return adminService.deleteSurvey(surveyId);
    }

    @RequestMapping(value = "/getPublishedSurvey", method = RequestMethod.GET)
    public ResponseObject getPublishedSurveys() {

        return adminService.getPublishedSurveys();
    }

    
    @RequestMapping(value = "/getSurveysForAnalysis", method = RequestMethod.GET)
    public ResponseObject getSurveysForAnalysis() {

        return adminService.getSurveysForAnalysis();
    }

    @RequestMapping(value = "/getSurveyResponses", method = RequestMethod.POST)
    public ResponseObject getSurveyResponses(@RequestBody Map<String, Long> data) {

        return this.adminService.getSurveyResponses(data.get("surveyId"), data.get("from"), data.get("to"));
    }

    @RequestMapping(value = "/getSurveyResponsesForChart", method = RequestMethod.GET)
    public ResponseObject getSurveyResponsesForChart() {

        return adminService.getSurveyResponsesForChart();
    }
}