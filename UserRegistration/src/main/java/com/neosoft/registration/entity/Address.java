package com.neosoft.registration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * The Class Address.
 * 
 * @author Santoshi Yadav
 * 
 */
@Entity
@Data
@Table(name = "address")
@NoArgsConstructor

/**
 * Instantiates a new address.
 *
 * @param id the id
 * @param hno the house Number
 * @param street the street
 * @param area the area
 * @param city the city
 * @param pincode the pincode
 */
@AllArgsConstructor
public class Address implements Serializable{

	/** The id. */
	@Id
	@Column(name = "user_id")
	private Integer id;
	
	/** The hno. */
	@Column(name = "house_number",length = 20)
	private String hno;
	
	/** The street. */
	@Column(length = 25)
	private String street;
	
	/** The area. */
	@Column(length = 30)
	private String area;
	
	/** The city. */
	@Column(length = 25)
	private String city;
	
	/** The pincode. */
	@Column
	private Integer pincode;
	
}
