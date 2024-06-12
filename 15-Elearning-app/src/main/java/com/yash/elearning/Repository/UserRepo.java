package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
