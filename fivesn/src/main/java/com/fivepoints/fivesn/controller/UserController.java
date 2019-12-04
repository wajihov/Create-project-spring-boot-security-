package com.fivepoints.fivesn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fivepoints.fivesn.entities.Role;
import com.fivepoints.fivesn.entities.User;
import com.fivepoints.fivesn.service.UserServes;

@RestController
@RequestMapping("/projet")
public class UserController {

	@Autowired
	private UserServes userServes;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(userServes.getAllUsers());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) {
		User user = userServes.getUsersById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return ResponseEntity.ok().body(userServes.createUser(user));
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) {
		return ResponseEntity.ok(userServes.updateUser(userId, userDetails));
	}

	@DeleteMapping("/user/{id}")
	public Boolean deleteUser(@PathVariable(value = "id") Long userId) {
		return userServes.deleteUser(userId);
	}

	@GetMapping("/usersByRole")
	public ResponseEntity<List<User>> getAllUsersByRole(@RequestParam(defaultValue = "user") Role role) {
		return ResponseEntity.ok().body(userServes.getUserByRole(role));
	}

	@GetMapping("/usersByName")
	public ResponseEntity<List<User>> getAllUsersByName(@RequestParam(defaultValue = "") String mc) {
		return ResponseEntity.ok().body(userServes.getUserByName(mc));
	}

}