package com.yash.elearning.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.elearning.Repository.UserRepo;
import com.yash.elearning.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	// Create a new user
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	// Update an existing user
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
		return userRepo.findById(userId).map(existingUser -> {
			existingUser.setUsername(updatedUser.getUsername());
			existingUser.setPassword(updatedUser.getPassword());
			// Update other fields as needed
			return userRepo.save(existingUser);
		}).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
	}

	// Delete a user by ID
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		userRepo.deleteById(userId);
		return "User with id " + userId + " deleted successfully.";
	}

	// View all users
	@GetMapping("/viewAllUser")
	public List<User> viewAllUsers() {
		return userRepo.findAll();
	}
}
