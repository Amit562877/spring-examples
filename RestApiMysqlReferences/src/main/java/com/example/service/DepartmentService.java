package com.example.service;

import java.util.List;

import com.example.model.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();

	Department getDepartmentById(int id);

	Department saveDepartment(Department d);

	Department updateDepartment(Department d);

	void deleteDepartment(int id);

	boolean departmentExists(int id);
}
