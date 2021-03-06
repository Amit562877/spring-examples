package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/api/users")
	public ModelAndView getAllUsers() {
		List<User> users = userService.getAllUsers();
		Map<String, Object> params = new HashMap<>();
		params.put("students", users);
		return new ModelAndView("index", params);
	}

	@RequestMapping(value = { "/", "/Hello" })
	public ResponseEntity<String> getGreetings() {
		return new ResponseEntity<String>("Hello, Good Morning!", HttpStatus.OK);
	}

	@RequestMapping(value = { "/get", "/Hello" })
	public ModelAndView demo() {
		return new ModelAndView("saveStudent");
	}

	@PostMapping("/api/users")
	public ResponseEntity<User> saveUsers(@RequestBody User user) {
		if (userService.userExists(user.getStudent_Id())) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/api/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
	}

//	@GetMapping("/api/users")
//	public ResponseEntity<List<User>> getAllUsers1() {
//		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//	}

	@GetMapping("/api/users/{id}")
	public ResponseEntity<?> getAllUserById(@PathVariable int id) {
		if (!userService.userExists(id)) {
			return new ResponseEntity<Error>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	@DeleteMapping("/api/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		if (!userService.userExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
