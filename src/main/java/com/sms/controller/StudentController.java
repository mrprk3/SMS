package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student;
import com.sms.handler.ServiceResponse;
import com.sms.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	Logger log = LoggerFactory.getLogger(StudentController.class);

	// To Save student data into database
	@PostMapping("/save")
	@CachePut(value = "student", key = "#stud.id")
	public ServiceResponse<Student> saveStudent(@RequestBody @Valid Student stud) {
		log.info("starting save method for student");
		Student std = studentService.saveStudent(stud);
		ServiceResponse<Student> response = new ServiceResponse<>();
		response.setResponse(std);
		response.setStatus(HttpStatus.OK);
		response.setError(null);
		log.info("successfully saved student");
		return response;
	}

	// To get student data from database
	@GetMapping("/get/{id}")
	@Cacheable(value = "student", key = "#id")
	public ServiceResponse<Student> getStudentData(@PathVariable int id) {
		log.info("starting getStudentData() method for student");
		ServiceResponse<Student> response = new ServiceResponse<>();
		Student studentData = studentService.getStudentData(id);
		response.setResponse(studentData);
		response.setStatus(HttpStatus.OK);
		return response;
	}

	// To update the student object
	@PutMapping("/update")
	@CachePut(value = "student", key = "#stud.id")
	public ServiceResponse<Student> updateStudent(@RequestBody Student student) {
		log.info("starting updateStudent() method for student");
		ServiceResponse<Student> response = new ServiceResponse<>();
		Student updateStudent = studentService.updateStudent(student);
		response.setResponse(updateStudent);
		response.setStatus(HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "student", key = "#id")
	public ServiceResponse<String> deleteStudentById(@PathVariable int id) {
		ServiceResponse<String> response = new ServiceResponse<>();
		studentService.deleteStudentById(id);
		response.setResponse("Student data has been deleted....");
		response.setStatus(HttpStatus.OK);
		return response;
	}

	// Get all the student sorting order
	@GetMapping("/sort/{feild}")
	public List<Student> getStudentDataSorting(@PathVariable String feild) {
		log.info("starting getStudentDataSorting() method for student");
		return studentService.getStudentWithSort(feild);
	}

	// Get all the student with page wise
	@GetMapping("/get/{offset}/{limit}")
	public Page<Student> getStudentWithPagination(@PathVariable int offset, @PathVariable int limit) {
		return studentService.getStudentWithPagination(offset, limit);
	}

}
