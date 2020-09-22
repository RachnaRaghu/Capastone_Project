package com.example.capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.SurveyResponse;
@Repository
public interface SurveyResponseRepo extends CrudRepository<SurveyResponse, String>{

	@Query(value = "select s from SurveyResponse s where s.emailId=?1 and s.surveyId=?2")
    public SurveyResponse findByEmailIdAndSurveyId(String emailId, Long surveyId);

    @Query(value= "select s from SurveyResponse s where s.takenOn >=?2 and s.takenOn<=?3 and surveyId=?1")
    public List<SurveyResponse> findByAll(Long surveyId, Long from, Long to);
    
    @Query(value= "select s from SurveyResponse s where s.takenOn >=?2 and surveyId=?1")
    public List<SurveyResponse> findByDateFrom(Long surveyId, Long from);

    @Query(value= "select s from SurveyResponse s where s.takenOn<=?2 and surveyId=?1")
    public List<SurveyResponse> findByDateTo(Long surveyId, Long to);
    
    @Query(value= "select s from SurveyResponse s where s.takenOn >=?1 and s.takenOn<=?2")
    public List<SurveyResponse> findByDateRange(Long from, Long to);

    public List<SurveyResponse> findBySurveyId(long surveyId);

}
