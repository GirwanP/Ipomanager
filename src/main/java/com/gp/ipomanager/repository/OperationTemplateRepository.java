package com.gp.ipomanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.ipomanager.entities.ActionParam;
import com.gp.ipomanager.entities.OperationTemplate;

public interface OperationTemplateRepository extends JpaRepository<OperationTemplate, Long> {
	
	@Query("select a.actions from OperationTemplate a where a.id =?1")
	List<ActionParam> getActionParams(long templateid);
    
	
}
