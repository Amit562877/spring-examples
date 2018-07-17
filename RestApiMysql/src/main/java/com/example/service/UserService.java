package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(int id);

	User saveUser(User u);

	User updateUser(User u);

	void deleteUser(int id);

	boolean userExists(int id);
}
