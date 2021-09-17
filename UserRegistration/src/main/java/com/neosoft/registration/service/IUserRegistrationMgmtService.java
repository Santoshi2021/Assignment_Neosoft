package com.neosoft.registration.service;

import java.util.List;

import com.neosoft.registration.entity.User;
/**
 * The Interface IUserRegistrationMgmtService.
 * 
 * @author Santoshi Yadav
 * 
 */
public interface IUserRegistrationMgmtService {

	/**
	 * Insert user data.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User insertUserData(User user);
	
	/**
	 * Gets the by first name.
	 *
	 * @param fName the f name
	 * @return the by first name
	 */
	public List<User> getByFirstName(String fName);
	
	/**
	 * Gets the by last name.
	 *
	 * @param lName the l name
	 * @return the by last name
	 */
	public List<User> getByLastName(String lName);
	
	/**
	 * Gets the by pincode.
	 *
	 * @param pincode the pincode
	 * @return the by pincode
	 */
	public List<User> getByPincode(Integer pincode);
	
	/**
	 * Gets the all order of DOB.
	 *
	 * @return the all order of DOB
	 */
	public List<User> getAllOrderOfDOB();
	
	/**
	 * Gets the all order of DOJ.
	 *
	 * @return the all order of DOJ
	 */
	public List<User> getAllOrderOfDOJ();
	
	/**
	 * Gets the by user id.
	 *
	 * @param id the id
	 * @return the by user id
	 */
	public User getByUserId(String id);
	
	/**
	 * Update user by id.
	 *
	 * @param user the user
	 * @return the string
	 */
	public String updateUserById(User user);
	
	/**
	 * Temporary user deletion.
	 *
	 * @param id the id
	 * @return the string
	 */
	public String temporaryUserDeletion(Integer id);
	
	/**
	 * Permanent user deletion.
	 *
	 * @param id the id
	 * @return the string
	 */
	public String permanentUserDeletion(Integer id);
	
	/**
	 * Find all user.
	 *
	 * @return the list
	 */
	public List<User> findAllUser();
}
