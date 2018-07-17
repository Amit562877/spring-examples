package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "department")
public class Department {
	public int getDepartment_Id() {
		return Department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		Department_Id = department_Id;
	}

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Department_Id;

	@Column(length = 30, nullable = false)
	String Department_Name;

	

}
