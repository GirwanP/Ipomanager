package com.gp.ipomanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.ipomanager.entities.DmatAccount;

public interface DmatRepository extends JpaRepository<DmatAccount, Long> {
	
	@Query("select d from DmatAccount d where d.applicant.id=?1")
	public Optional<DmatAccount> getForApplicant(long applicantId);
	
}
