package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.getOne(id);
	}

	@Override
	public Department saveDepartment(Department d) {
		// TODO Auto-generated method stub
		return departmentRepository.save(d);
	}

	@Override
	public Department updateDepartment(Department d) {
		// TODO Auto-generated method stub
		return departmentRepository.save(d);
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

	@Override
	public boolean departmentExists(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.existsById(id);
	}

}
