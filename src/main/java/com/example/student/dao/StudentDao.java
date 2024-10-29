package com.example.student.dao;

import java.util.List;
import java.util.Optional;

import com.example.student.modal.Student;

public interface StudentDao {

	void deleteById(Integer id);

	List<Student> findAll();

	Student save(Student entity);

	Student update(Integer id, Student entity);

	Optional<Student> findById(Integer id);

	List<Student> findByFullName(String fullName);

}
