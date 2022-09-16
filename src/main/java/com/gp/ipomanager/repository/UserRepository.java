package com.gp.ipomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.ipomanager.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
