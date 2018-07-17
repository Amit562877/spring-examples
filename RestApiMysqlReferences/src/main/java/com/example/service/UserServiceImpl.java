package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public User saveUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public boolean userExists(int id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

}
