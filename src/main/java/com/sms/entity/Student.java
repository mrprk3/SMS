package com.sms.entity;

import com.sms.annotation.StudentGenderValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {
	@Id
	@Column(name = "student_id")
	private int id;

	@NotEmpty(message = "Name should not be null ")
	@Column(name = "student_name")
	private String name;

	@Column(name = "student_phone")
	private String phone;

	@Column(name = "student_email")
	@Email(message = "please enter valid email id")
	private String email;

	@Column(name = "is_active")
	private boolean active;

	@Column(name = "student_gender")
	@StudentGenderValidation
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student(int id, @NotEmpty(message = "Name should not be null ") String name, String phone,
			@Email(message = "please enter valid email id") String email, boolean active, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.active = active;
		this.gender = gender;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
