package com.org.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public boolean existsByEmailId(String emailId);

	public User findByEmailId(String emailId);
	
	
	   
	    

}
