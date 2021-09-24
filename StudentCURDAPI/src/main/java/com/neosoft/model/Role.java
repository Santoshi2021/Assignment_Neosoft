package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class Role for authorization.
 * 
 * @author Santoshi Yadav
 * 
 */
@Entity
@Table(name = "roles")
@Data

/**
 * Instantiates a new role.
 */
public class Role {
	
	/** The id. */
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The role name. */
	@Column
	private String name;

}
