package com.fivepoints.fivesn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fivepoints.fivesn.dao.UserRepository;
import com.fivepoints.fivesn.entities.Role;
import com.fivepoints.fivesn.entities.User;

@Service
public class UserServes {

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Bean private BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	public List<User> getAllUsers() {
		List<User> lists = new ArrayList<User>();
		try {
			lists = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	public User getUsersById(Long userId) {
		User user = new User();
		try {
			user = userRepository.findById(userId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User createUser(User user) {
		User userSave = new User();

		try {
			// user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
			userSave = userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userSave;
	}

	public User updateUser(Long userId, User userDetails) {

		User user = userRepository.findById(userId).get();
		try {
			user.setName(userDetails.getName());
			user.setSurname(userDetails.getSurname());
			user.setEmail(userDetails.getEmail());
			user.setPassword(userDetails.getPassword());
			user.setBirthDay(userDetails.getBirthday());
			user.setPhone(userDetails.getPhone());
			user.setDescription(userDetails.getDescription());
			user.setRole(userDetails.getRole());
			user.setGender(userDetails.getGender());
			user.setEnabled(userDetails.getEnabled());
			user.setBlocked(userDetails.getBlocked());
		} catch (Exception e) {
			e.printStackTrace();
		}
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public Boolean deleteUser(Long userId) {
		Boolean test = false;
		try {
			User user = userRepository.findById(userId).get();
			if (user != null) {
				userRepository.delete(user);
				test = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}

	public List<User> getUserByRole(Role role) {
		List<User> lists = new ArrayList<User>();
		try {
			lists = userRepository.getUserByRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	public List<User> getUserByName(String nom) {
		List<User> lists = new ArrayList<User>();
		try {
			lists = userRepository.getUserByName(nom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

}
