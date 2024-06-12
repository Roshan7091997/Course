package com.yash.elearning.Controller;

import com.yash.elearning.Repository.StudentRepo;
import com.yash.elearning.model.Student;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

   
    // Delete a student by ID
    @DeleteMapping("/deletestudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studentRepo.deleteById(studentId);
        return "Student with id " + studentId + " deleted successfully.";
    }

    // View all students
    @GetMapping("/viewAllstudent")
    public List<Student> viewAllStudents() {
        return studentRepo.findAll();
    }
}
