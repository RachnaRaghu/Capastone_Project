package com.example.capstone;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.capstone.contoller.UserController;
import com.example.capstone.entity.QuestionResponse;
import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.entity.User;
import com.example.capstone.service.AdminService;
import com.example.capstone.service.UserService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	UserController userController;
	
	@Mock
	AdminService adminService;
	
	@Mock
    UserService userService;	
	
	@Before
	public void setUp()
	{
		userController = new UserController();
		ReflectionTestUtils.setField(userController, "adminService", adminService);
		ReflectionTestUtils.setField(userController, "userService", userService);
	}
	
	@Test
	public void createUserTest() {
		User user = new User();
		user.setEmailId("rachna@wipro.com");
		user.setId(2);
		user.setMobilenumber("9876543210");
		user.setPassword("123");
		user.setUserName("rachna");

		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.createUser(any())).thenReturn(result);
		userController.createUser(user);
	}
	
	@Test
	public void loginTest() {
		User user = new User();
		user.setEmailId("rachna@wipro.com");
		user.setId(2);
		user.setMobilenumber("9876543210");
		user.setPassword("123");
		user.setUserName("rachna");
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.login(any())).thenReturn(result);
		userController.login(user);

	}
	
	@Test
	public void checkuserTest() {
		
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(userService.checkuser(any())).thenReturn(result, result);
		SurveyResponse surveyResponse = new SurveyResponse();
		surveyResponse.setCreatedOn(20l);
		surveyResponse.setEmailId("emailId");
		surveyResponse.setId(23l);
		surveyResponse.setName("name");
		List<QuestionResponse> questionList = new ArrayList();
		QuestionResponse qusResponse = new QuestionResponse();
		questionList.add(qusResponse);
		surveyResponse.setQuestions(questionList );
		surveyResponse.setsurveyId(13l);
		surveyResponse.setSurveyName("surveyName");
		surveyResponse.setTakenOn(19l);
		surveyResponse.setValidTill(30l);
		userController.checkUser(surveyResponse );

	}
	
	@Test
	public void saveResponseTest() {
		SurveyResponse surveyResponse = new SurveyResponse();
		surveyResponse.setCreatedOn(20l);
		surveyResponse.setEmailId("emailId");
		surveyResponse.setId(23l);
		surveyResponse.setName("name");
		List<QuestionResponse> questionList = new ArrayList<>();
		QuestionResponse qusResponse = new QuestionResponse();
		questionList.add(qusResponse);
		surveyResponse.setQuestions(questionList );
		surveyResponse.setsurveyId(13l);
		surveyResponse.setSurveyName("surveyName");
		surveyResponse.setTakenOn(19l);
		surveyResponse.setValidTill(30l);
		
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(userService.saveResponse(any())).thenReturn(result, result);
		userController.saveResponse(surveyResponse);

	}
	

}
