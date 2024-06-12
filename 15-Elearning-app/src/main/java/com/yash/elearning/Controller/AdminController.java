package com.yash.elearning.Controller;

import com.yash.elearning.Repository.AdminRepo;
import com.yash.elearning.model.Admin;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

  
    // View all admins
    @GetMapping("/viewAll")
    public List<Admin> viewAllAdmins() {
        return adminRepo.findAll();
    }
}
