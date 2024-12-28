package com.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findById(int id);
}
