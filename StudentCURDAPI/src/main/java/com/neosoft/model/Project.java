package com.neosoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/**
 * The Class Project.
 * 
 * @author Santoshi Yadav
 * 
 */
@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor

/**
 * Instantiates a new project.
 *
 * @param pname the project name
 * @param duration the duration
 */

public class Project implements Serializable{

	/** The pid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	/** The pname. */
	@NonNull
	@Column(length = 50)
	private String pname;
	
	/** The duration. */
	@NonNull
	@Column
	private Double duration;
}
