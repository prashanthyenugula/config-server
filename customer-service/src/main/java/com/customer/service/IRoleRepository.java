package com.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);

}
