package com.gp.ipomanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.ipomanager.entities.ActionParam;

public interface ActionParamsRepository extends JpaRepository<ActionParam, Long> {
	
	
}
