package com.yash.elearning.Controller;

import com.yash.elearning.Repository.CourseRepo;
import com.yash.elearning.model.Course;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    // Create a new course
    @PostMapping("/createcourse")
    public Course createCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

    // Update an existing course
    @PutMapping("/updatecourse/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody Course updatedCourse) {
        return courseRepo.findById(courseId)
                .map(existingCourse -> {
                    existingCourse.setCourseName(updatedCourse.getCourseName());
                    existingCourse.setDuration(updatedCourse.getDuration());
                    existingCourse.setCourseType(updatedCourse.getCourseType());
                    existingCourse.setCourseLanguage(updatedCourse.getCourseLanguage());
                    existingCourse.setCourseDescription(updatedCourse.getCourseDescription());
                    // Update other fields as needed
                    return courseRepo.save(existingCourse);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
    }

    // Delete a course by ID
    @DeleteMapping("/deletecourse/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        courseRepo.deleteById(courseId);
        return "Course with id " + courseId + " deleted successfully.";
    }

    // View all courses
    @GetMapping("/viewAllcourse")
    public List<Course> viewAllCourses() {
        return courseRepo.findAll();
    }
}
