package com.neosoft.registration.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class User.
 * 
 * @author Santoshi Yadav
 * 
 */
@Entity
@Table(name = "user")
@Data

/**
 * Instantiates a new user.
 *
 * @param id the id
 * @param fname the first name
 * @param lname the last name
 * @param email the email id
 * @param dob the date of birth
 * @param doj the date of joining
 * @param isActive the activation status
 * @param address the address
 */
@AllArgsConstructor

/**
 * Instantiates a new user.
 */
@NoArgsConstructor
public class User implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The fname. */
	@Column(length = 20)
	private String fname;

	/** The lname. */
	@Column(length = 20)
	private String lname;

	/** The email. */
	@Column(length = 30, unique = true)
	private String email;

	/** The dob. */
	@Column
	private LocalDate dob;

	/** The doj. */
	@Column
	private LocalDate doj;

	/** The is active. */
	@Column
	@JsonIgnore
	private Integer isActive = 0;

	/** The address. */
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;

}
