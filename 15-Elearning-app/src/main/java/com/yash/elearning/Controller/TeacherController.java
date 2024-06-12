package com.yash.elearning.Controller;

import com.yash.elearning.Repository.TeacherRepo;
import com.yash.elearning.model.Teacher;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class TeacherController {

    @Autowired
    private TeacherRepo teacherRepo;

   

    // Update an existing teacher
    @PutMapping("/updateteacher/{teacherId}")
    public Teacher updateTeacher(@PathVariable int teacherId, @RequestBody Teacher updatedTeacher) {
        return teacherRepo.findById(teacherId)
                .map(existingTeacher -> {
                    existingTeacher.setTeacherName(updatedTeacher.getTeacherName());
                    existingTeacher.setDegree(updatedTeacher.getDegree());
                    existingTeacher.setExperiance(updatedTeacher.getExperiance());
                    existingTeacher.setMobileNo(updatedTeacher.getMobileNo());
                    existingTeacher.setGender(updatedTeacher.getGender());
                    // Update other fields as needed
                    return teacherRepo.save(existingTeacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
    }

    // Delete a teacher by ID
    @DeleteMapping("/deleteteacher/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId) {
        teacherRepo.deleteById(teacherId);
        return "Teacher with id " + teacherId + " deleted successfully.";
    }

    // View all teachers
    @GetMapping("/viewAllteacher")
    public List<Teacher> viewAllTeachers() {
        return teacherRepo.findAll();
    }
}
