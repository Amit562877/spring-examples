package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Student_Id;

	@Column(length = 30, nullable = false)
	String Student_Name;

	@Column(length = 30, nullable = false)
	String City;

	@Column(length = 40, nullable = false)
	String Email;

	@Column(length = 10, nullable = false,columnDefinition="bigint")
	long Mobile;

	public int getStudent_Id() {
		return Student_Id;
	}

	public void setStudent_Id(int student_Id) {
		Student_Id = student_Id;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}
}