package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dao.StudentDao;
import com.example.student.modal.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
	@GetMapping("")
	public ResponseEntity<?> getListStudent(){
		return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") final Integer id){
		if(id != null) {
			Student s = studentDao.findById(id).get();
			return new ResponseEntity<>(s, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
		try {
			Student s = studentDao.save(student);
			return new ResponseEntity<>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") final Integer id, @RequestBody Student student){
		
		try {
			if(id != null) {
				Student s = studentDao.update(id, student);
				return new ResponseEntity<>(s, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") final Integer id){
		if(id != null) {
			studentDao.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("search/{fullName}")
	public ResponseEntity<?> search(@RequestParam("fullName") final String fullName){
		
		if(fullName != null) {
			return new ResponseEntity<>(studentDao.findByFullName(fullName), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
