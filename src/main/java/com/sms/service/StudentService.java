package com.sms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sms.entity.Student;
import com.sms.exception.StudentServiceBusinessException;
import com.sms.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	Logger log = LoggerFactory.getLogger(StudentService.class);

	public Student saveStudent(Student stud) {
		Student saveData = null;
		log.info("StudentService :: saveStudent method execution started");
		try {
			saveData = repository.save(stud);
			log.info("StudentService :: saveStudent method execution ended");
			return saveData;
		} catch (Exception e) {
			throw new StudentServiceBusinessException(" exception saveStudent method");

		}
	}

	public Student getStudentData(int id) {
		Student res = repository.findById(id);
		if (res == null) {
			throw new StudentServiceBusinessException("data not found with id" + id);
		}
		return res;
	}

	// sorting
	public List<Student> getStudentWithSort(String feild) {
		List<Student> res = repository.findAll(Sort.by(Sort.Direction.ASC, feild));
		return res;
	}

	// pagination
	public Page<Student> getStudentWithPagination(@PathVariable int offset, @PathVariable int limit) {
		return repository.findAll(PageRequest.of(offset, limit));
	}

	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	public void deleteStudentById(int id) {
		repository.deleteById(id);
	}

}
