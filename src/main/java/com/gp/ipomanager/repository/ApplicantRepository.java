package com.gp.ipomanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.ipomanager.entities.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	
	@Query("select a from Applicant a where a.disabled =?1")
	List<Applicant> getAllApplicantsByStatus(boolean disabled);
    
    
}
