package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer>{

}
