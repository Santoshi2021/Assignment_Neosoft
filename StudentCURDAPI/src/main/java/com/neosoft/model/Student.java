package com.neosoft.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The Class Student.
 * 
 * @author Santoshi Yadav
 * 
 */

@Entity
@Table(name="Student")
@Data

/**
 * Instantiates a new student.
 *
 * @param fname the first name
 * @param lname the last name
 * @param mobile the mobile number
 * @param email the email id
 */
@RequiredArgsConstructor
@NoArgsConstructor

/**
 * Instantiates a new student.
 */
public class Student implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The first name. */
	@Column(length = 15)
	@NonNull
	private String fname;
	
	/** The last name. */
	@Column(length = 15)
	@NonNull
	private String lname;
	
	/** The mobile number. */
	@Column
	@NonNull
	private Long mobile;
	
	/** The email id. */
	@Column(length = 30)
	@NonNull
	private String email;
	
	/** The project. */
	@OneToOne(targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_Id", referencedColumnName = "pid")
	private Project project;
}
