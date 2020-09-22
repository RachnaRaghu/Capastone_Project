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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.capstone.entity.QuestionResponse;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.repo.SurveyResponseRepo;
import com.example.capstone.service.UserService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	UserService userService;

	@Mock
	SurveyResponseRepo surveyResponseRepo;

	@Mock
	public JavaMailSender javaMailSender;

	@Before
	public void setUp() {
		userService = new UserService();
		ReflectionTestUtils.setField(userService, "surveyResponseRepo", surveyResponseRepo);
		ReflectionTestUtils.setField(userService, "javaMailSender", javaMailSender);
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
		surveyResponse.setQuestions(questionList);
		surveyResponse.setsurveyId(13l);
		surveyResponse.setSurveyName("surveyName");
		surveyResponse.setTakenOn(19l);
		surveyResponse.setValidTill(30l);

		when(surveyResponseRepo.save(any())).thenReturn(surveyResponse);
		userService.saveResponse(surveyResponse);

	}

	@Test
	public void checkuserTest() {
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

		when(surveyResponseRepo.findByEmailIdAndSurveyId(any(), any())).thenReturn(surveyResponse);
		when(surveyResponseRepo.save(any())).thenReturn(surveyResponse);
		userService.checkuser(surveyResponse);

	}

	@Test
	public void sendEmailTest() {
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

		when(surveyResponseRepo.findByEmailIdAndSurveyId(any(), any())).thenReturn(surveyResponse);
		when(surveyResponseRepo.save(any())).thenReturn(surveyResponse);

		userService.sendEmail(surveyResponse);

	}

}
