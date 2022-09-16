package com.gp.ipomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.ipomanager.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
