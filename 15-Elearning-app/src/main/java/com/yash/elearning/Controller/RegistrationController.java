package com.yash.elearning.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.elearning.DTO.StudentRegistrationRequest;
import com.yash.elearning.DTO.TeacherRegistrationRequest;
import com.yash.elearning.model.User;
import com.yash.elearning.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/register/teacher")
	public ResponseEntity<User> registerTeacher(@RequestBody TeacherRegistrationRequest request) {
		String username = request.getUsername();
		String password = request.getPassword();
		String teacherName = request.getTeacherName();
		String degree = request.getDegree();
		String mobileNo = request.getMobileNo();
		int experience = request.getExperience();

		User user = registrationService.registerTeacher(username, password, teacherName, degree, mobileNo, experience);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PostMapping("/register/student")
	public ResponseEntity<User> registerStudent(@RequestBody StudentRegistrationRequest request) {
		String username = request.getUsername();
		String password = request.getPassword();
		String studentName = request.getStudentName();

		User user = registrationService.registerStudent(username, password, studentName);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
