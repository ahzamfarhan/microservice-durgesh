package com.lcwd.userservice.services;

import java.util.List;

import com.lcwd.userservice.entities.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserByEmail(String email);
	User getUserById(String email);
	User updateUser(User user);
	void deleteUser(String userId);
	void deleteUserByEmail(String email);
}
