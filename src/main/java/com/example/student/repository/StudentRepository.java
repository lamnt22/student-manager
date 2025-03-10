package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student.modal.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT s FROM Student s WHERE s.fullName LIKE %?1%")
	List<Student> findByFullName(String fullName);
}
