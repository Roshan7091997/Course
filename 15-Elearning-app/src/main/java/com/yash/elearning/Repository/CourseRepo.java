package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
