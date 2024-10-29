package com.example.student.modal;




import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class Student {

	@Id
	@Column(name = "stu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stu_id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "birthDate")
	private String birthDate;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "gpa")
	private int gpa;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", referencedColumnName = "stu_id")
	private List<PersonalInformations> personalInformations = new ArrayList<>();;
	

	
}
