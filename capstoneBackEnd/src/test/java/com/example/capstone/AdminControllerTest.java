package com.example.capstone;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.capstone.contoller.AdminController;
import com.example.capstone.entity.Question;
import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.Survey;
import com.example.capstone.entity.User;
import com.example.capstone.service.AdminService;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {

	AdminController adminController;
	@Mock
	AdminService adminService;
	
	
	@Before
	public void setUp()
	{
		adminController = new AdminController();
		ReflectionTestUtils.setField(adminController, "adminService", adminService);
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
		adminController.createUser(user);
	}

	/*@Test
	public void launchServeyTest() {
		Map<String, Integer> surveyId = new HashMap<>();
		surveyId.put("surveyId", 25);
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject(25);
		when(adminService.launchSurvey(25)).thenReturn(result);
		adminController.launchSurvey(surveyId);

	}*/

	@Test
	public void saveSurveyTest() {
		Survey survey = new Survey();
		survey.setCreatedOn(12);
		survey.setDescription("description");
		survey.setId(24);
		List<Question> questionList = new ArrayList<>();
		Question question = new Question();
		questionList.add(question);
		survey.setQuestions(questionList);
		survey.setStatus("published");
		survey.setSurveyExpiresOn(25);
		survey.setSurveyName("cms");
		survey.setSurveyTitle("surveyTitle");
		survey.setValidTill(30);
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.saveSurvey(any())).thenReturn(result);
		adminController.saveSurvey(survey);
	}

	@Test
	public void deleteSurveyTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.deleteSurvey(23)).thenReturn(result);
		adminController.deleteSurvey(23);

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
		adminController.login(user);

	}
	
	@Test
	public void getAllSurveys() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getAllSurveys()).thenReturn(result);
		adminController.getAllSurveys();		
	}
	
	@Test
	public void getPublishedSurveysTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getPublishedSurveys()).thenReturn(result);
		adminController.getPublishedSurveys();
	}
	
	@Test
	public void getSurveyTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getSurvey(25)).thenReturn(result);
		adminController.getSurvey(25);
	}
	
	@Test
	public void getSurveyResponsesTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getSurveyResponses(anyLong(), anyLong(), anyLong())).thenReturn(result);
		Map<String, Long> map = new HashMap<>();
		adminController.getSurveyResponses(map);
	}
	
	@Test
	public void getSurveyResponsesForChartTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getSurveyResponsesForChart()).thenReturn(result);
		
		adminController.getSurveyResponsesForChart();
	}
	
	@Test
	public void getSurveysForAnalysisTest() {
		ResponseObject result = new ResponseObject();
		result.setResult(true);
		result.setResultObject("success");
		when(adminService.getSurveysForAnalysis()).thenReturn(result);
		
		adminController.getSurveysForAnalysis();
	}
	
	
	

}
