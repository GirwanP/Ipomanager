package com.gp.ipomanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.ipomanager.entities.IPOOpening;

public interface IpoOpeningRepository extends JpaRepository<IPOOpening, Long> {
	
	@Query("select a from IPOOpening a where a.issueOpen =?1")
	List<IPOOpening> getAllIPOOpeningsByStatus(boolean open);
    
	
}
