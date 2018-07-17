package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/Department", method = RequestMethod.GET)
	public String Init() {
		return "welcome to department controller!";
	}

	@GetMapping("/api/department/")
	public ResponseEntity<?> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		if (departments != null) {
			return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
		}
		return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/api/department/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable int id) {
		if (!departmentService.departmentExists(id)) {
			return new ResponseEntity<Error>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(departmentService.getDepartmentById(id),HttpStatus.FOUND);
	}

	@PostMapping("/api/department/")
	public ResponseEntity<?> saveDepartment(@RequestBody Department d) {
		if (departmentService.departmentExists(d.getDepartment_Id())) {
			return new ResponseEntity<Error>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Department>(departmentService.saveDepartment(d), HttpStatus.CREATED);
	}
}
