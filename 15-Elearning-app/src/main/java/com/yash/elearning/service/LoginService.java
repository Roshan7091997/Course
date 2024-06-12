package com.yash.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.elearning.Repository.AdminRepo;
import com.yash.elearning.Repository.StudentRepo;
import com.yash.elearning.Repository.TeacherRepo;
import com.yash.elearning.Repository.UserRepo;
import com.yash.elearning.model.User;

@Service
public class LoginService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    public String loginUser(String username, String password, String userType) {
        // Assuming username is unique across admin, student, and teacher
        User user = userRepo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            switch (userType.toLowerCase()) {
                case "admin":
                    return "Admin login successful!";
                case "student":
                    return "Student login successful!";
                case "teacher":
                    return "Teacher login successful!";
                default:
                    return "Invalid user type";
            }
        }

        return "Invalid username or password";
    }
}
