package com.example.student.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "personalInformations")
@Data
public class PersonalInformations {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "relationship")
	private int relationship;
	
	@Column(name = "birthDate")
	private String birthDate;
	
	@Column(name = "gender")
	private int gender;


	
}
