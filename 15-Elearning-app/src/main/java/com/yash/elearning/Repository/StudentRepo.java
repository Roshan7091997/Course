package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
