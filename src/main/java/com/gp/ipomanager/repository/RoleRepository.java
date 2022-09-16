package com.gp.ipomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.ipomanager.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByName(String name);
}
