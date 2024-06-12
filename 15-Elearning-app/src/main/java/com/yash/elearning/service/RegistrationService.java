package com.yash.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.elearning.Repository.RoleRepo;
import com.yash.elearning.Repository.StudentRepo;
import com.yash.elearning.Repository.TeacherRepo;
import com.yash.elearning.Repository.UserRepo;
import com.yash.elearning.model.Role;
import com.yash.elearning.model.Student;
import com.yash.elearning.model.Teacher;
import com.yash.elearning.model.User;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class RegistrationService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private TeacherRepo teacherRepository;

    @Autowired
    private StudentRepo studentRepository;

    public User registerTeacher(String username, String password, String teacherName, String degree, String mobileNo, int experience) {
        // Find or create the teacher role
        Role teacherRole = roleRepository.findByRoleName("teacher");

        // Create the teacher entity
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setDegree(degree);
        teacher.setExperiance(experience);
        teacher.setMobileNo(mobileNo);

        teacher = teacherRepository.save(teacher);

        // Create the user entity
        User user = new User(username, password, teacherRole);
        user = userRepository.save(user);

        return user;
    }


    public User registerStudent(String username, String password, String studentName) {
        // Find or create the student role
        Role studentRole = roleRepository.findByRoleName("STUDENT");

        // Create the student entity
        Student student = new Student();
        student.setStudeName(studentName);
        student = studentRepository.save(student);

        // Create the user entity
        User user = new User(username, password, studentRole);
        user = userRepository.save(user);

        return user;
    }
}
