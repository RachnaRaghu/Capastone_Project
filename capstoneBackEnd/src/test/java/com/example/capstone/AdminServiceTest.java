package com.example.capstone;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.capstone.entity.Question;
import com.example.capstone.entity.QuestionResponse;
import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.Survey;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.entity.User;
import com.example.capstone.repo.SurveyRepo;
import com.example.capstone.repo.SurveyResponseRepo;

import com.example.capstone.repo.UserRepo;
import com.example.capstone.service.AdminService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	
	AdminService adminService;
	
	@Mock
    UserRepo userRepo;

	@Mock
    SurveyRepo surveyRepo;
    
	@Mock
	 SurveyResponseRepo surveyResponseRepo;
	
	@Before
	public void setUp()
	{
		adminService = new AdminService();
		ReflectionTestUtils.setField(adminService, "surveyRepo", surveyRepo);
		ReflectionTestUtils.setField(adminService, "surveyResponseRepo", surveyResponseRepo);
		ReflectionTestUtils.setField(adminService, "userRepo", userRepo);
		
	}
	
	@Test
	public void saveSurveyTest() {
		Survey survey = new Survey();
		survey.setCreatedOn(20l);
		survey.setId(23);
		List<Question> questionList = new ArrayList<>();
		Question qusResponse = new Question();
		questionList.add(qusResponse);
		survey.setQuestions(questionList);
	    survey.setSurveyName("surveyName");
		survey.setValidTill(30l);
		when(surveyRepo.save(any())).thenReturn(survey);
		adminService.saveSurvey(survey);
		
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
		when(userRepo.save(any())).thenReturn(user);
		adminService.createUser(user);
		
	}
	
	@Test
	public void deleteSurveyTest() {
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(surveyRepo).deleteById(anyInt());
		adminService.deleteSurvey(12);
		
	}
	
	@Test
	public void getAllSurveysTest() {		
		List<Survey> surveyList = new ArrayList<>();
		Survey survey = new Survey();
		surveyList.add(survey);
		when(surveyRepo.findAll()).thenReturn(surveyList);
		adminService.getAllSurveys();
		
	}
	
	@Test
	public void getPublishedSurveyTest() {		
		List<Survey> surveyList = new ArrayList<>();
		Survey survey = new Survey();
		surveyList.add(survey);
		when(surveyRepo.findAllPublishedSurveys()).thenReturn(surveyList);
		adminService.getPublishedSurveys();
		
	}
	
	@Test
	public void getSurveyTest() {				
		when(surveyRepo.findById(12)).thenReturn(Optional.empty());
		adminService.getSurvey(12);
		
	}
	@Test
	public void getSurveyResponseTest1() {
		List<SurveyResponse> result = new ArrayList<>();
		SurveyResponse response = new SurveyResponse();
		result.add(response);
		when(surveyResponseRepo.findByDateRange(any(),any())).thenReturn(result);
		adminService.getSurveyResponses(1278l, 223l, 301l);
	}
	
	@Test
	public void getSurveyResponseTest2() {
		List<SurveyResponse> result = new ArrayList<>();
		SurveyResponse response = new SurveyResponse();
		result.add(response);
		when(surveyResponseRepo.findByDateRange(any(),any())).thenReturn(result);
		adminService.getSurveyResponses(null, 223l, 301l);
	}
	
	@Test
	public void getSurveyResponseTest3() {
		List<SurveyResponse> result = new ArrayList<>();
		SurveyResponse response = new SurveyResponse();
		result.add(response);
		when(surveyResponseRepo.findByDateFrom(any(),any())).thenReturn(result);
		adminService.getSurveyResponses(1278l, 223l, null);
	}
	
	@Test
	public void getSurveyResponseTest4() {
		List<SurveyResponse> result = new ArrayList<>();
		SurveyResponse response = new SurveyResponse();
		result.add(response);
		when(surveyResponseRepo.findByDateTo(anyLong(),anyLong())).thenReturn(result);
		adminService.getSurveyResponses(23l, null, 345l);
	}
	
	@Test
	public void getSurveyResponseTest5() {
		List<SurveyResponse> result = new ArrayList<>();
		SurveyResponse surveyResponse = new SurveyResponse();
		surveyResponse.setCreatedOn(20l);
		surveyResponse.setEmailId("emailId");
		surveyResponse.setId(23l);
		surveyResponse.setName("name");
		List<QuestionResponse> questionList = new ArrayList<>();
		QuestionResponse qusResponse = new QuestionResponse();
		questionList.add(qusResponse);
		surveyResponse.setQuestions(questionList);
		surveyResponse.setsurveyId(13l);
		surveyResponse.setSurveyName("surveyName");
		surveyResponse.setTakenOn(19l);
		surveyResponse.setValidTill(30l);
		result.add(surveyResponse);
		when(surveyResponseRepo.findBySurveyId(anyLong())).thenReturn(result);
		adminService.getSurveyResponses(12l, null, null);
	}
	
	@Test
	public void getSurveyForChartTest() {
			
		List<Survey> surveyList = new ArrayList<>();
		Survey survey = new Survey();
		List<Question> questionList = new ArrayList<>();
		Question qusResponse = new Question();
		questionList.add(qusResponse);
		survey.setQuestions(questionList);
	    survey.setSurveyName("surveyName");
		survey.setValidTill(30l);
		surveyList.add(survey);
		when(surveyRepo.findSurveysForAnalysis()).thenReturn(surveyList);
		adminService.getSurveyResponsesForChart();
	}
	
	@Test
	public void getSurveysForAnalysisTest() {
		
		List<Survey> surveyList = new ArrayList<>();
		Survey survey = new Survey();
		surveyList.add(survey);
		when(surveyRepo.findSurveysForAnalysis()).thenReturn(surveyList);
		adminService.getSurveysForAnalysis();
	}

	/*@Test
	public void launchSurveyTest() {
		Survey survey = new Survey();
		survey.setCreatedOn(20l);
		survey.setId(23);
		List<Question> questionList = new ArrayList<>();
		Question qusResponse = new Question();
		questionList.add(qusResponse);
		survey.setQuestions(questionList);
	    survey.setSurveyName("surveyName");
		survey.setValidTill(30l);
		
		when(surveyRepo.findById(any())).thenReturn(Optional.empty());
		when(surveyRepo.save(any())).thenReturn(survey);
		adminService.launchSurvey(23);
	}*/
	
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
		when(userRepo.findByEmailAndPassword(any(), any())).thenReturn(user);
		adminService.login(user);
	}
	
}
