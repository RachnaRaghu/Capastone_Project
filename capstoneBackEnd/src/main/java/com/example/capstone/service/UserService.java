package com.example.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.capstone.entity.ResponseObject;
import com.example.capstone.entity.SurveyResponse;
import com.example.capstone.repo.SurveyResponseRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

	@Autowired
	SurveyResponseRepo surveyResponseRepo;

	@Autowired
	public JavaMailSender javaMailSender;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public ResponseObject saveResponse(SurveyResponse surveyResponse) {

		LOGGER.info("Saving Response {}", surveyResponse);
		ResponseObject responseObj = new ResponseObject(true, "response saved successfully");
		surveyResponseRepo.save(surveyResponse);
		sendEmail(surveyResponse);
		LOGGER.info("Response saved");
		return responseObj;
	}

	public ResponseObject checkuser(SurveyResponse surveyResponse) {

		LOGGER.info("Checking user {}", surveyResponse);
		ResponseObject responseObject;
		SurveyResponse response = surveyResponseRepo.findByEmailIdAndSurveyId(surveyResponse.getEmailId(),
				surveyResponse.getsurveyId());
		if (response == null) {
			responseObject = new ResponseObject(true, "New user");
		} else {
			responseObject = new ResponseObject(false, "Already taken");
		}
		LOGGER.info("Result {}", responseObject);
		return responseObject;
	}

	public boolean sendEmail(SurveyResponse receiver) {

		LOGGER.info("Sending  Email Notification to {}", receiver.getEmailId());
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(receiver.getEmailId());

		msg.setSubject("Survey Submission Details");
		String message = "Hello  " + receiver.getName() + "\nThis is to notify that you have successfully submitted "
				+ receiver.getSurveyName() + " survey\n Thanks & Regards,\nCampaign Management System";
		msg.setText(message);

		try {
			javaMailSender.send(msg);
			LOGGER.info("Email notification sent to {}", receiver.getEmailId());
		} catch (Exception e) {
			LOGGER.info("Some error occured while sending email to {}", receiver.getEmailId());
			e.printStackTrace();
		}
		return true;
	}

}
