package com.example.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.modal.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private StudentRepository repo;

	@Override
	public Student save(Student entity) {
		return repo.save(entity);
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public Student update(Integer id, Student entity) {
		Student s = repo.findById(id).get();
		s.setFullName(entity.getFullName());
		s.setBirthDate(entity.getBirthDate());
		s.setGender(entity.getGender());
		s.setGpa(entity.getGpa());
		s.setPersonalInformations(entity.getPersonalInformations());
		return repo.save(s);
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Student> findByFullName(String fullName) {
		return repo.findByFullName(fullName);
	}
	
	
}
