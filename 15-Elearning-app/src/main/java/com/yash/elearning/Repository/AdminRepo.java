package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
