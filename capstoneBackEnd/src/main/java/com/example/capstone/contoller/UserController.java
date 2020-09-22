package com.example.capstone.contoller;

import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.entity.User;
import com.example.capstone.service.AdminService;
import com.example.capstone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    
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

    @RequestMapping(value="/saveResponse", method = RequestMethod.POST)
    public ResponseObject saveResponse(@RequestBody SurveyResponse surveyResponse) {
        return userService.saveResponse(surveyResponse);
    }

    
    @RequestMapping(value="/checkUser", method = RequestMethod.POST)
    public ResponseObject checkUser(@RequestBody SurveyResponse surveyResponse) {
        return userService.checkuser(surveyResponse);
    }
}
