/**
 * @author RA20076375
 *
 */
package com.example.capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.capstone.entity.Survey;


@Repository
public interface SurveyRepo extends CrudRepository<Survey, Integer>{

	 @Query(value = "select * from Survey where status='PUBLISHED'", nativeQuery = true)
    public List<Survey> findAllPublishedSurveys();

	 @Modifying
	    @Transactional
	    @Query(value = "UPDATE survey SET status='EXPIRED' WHERE valid_till<:currentDate and status!='EXPIRED'", nativeQuery = true)
    public int updateStatus(@Param("currentDate") Long currentTime);

    @Query(value = "select s from Survey s where s.status!='DRAFT' order by s.id")
    public List<Survey> findSurveysForAnalysis();
}

