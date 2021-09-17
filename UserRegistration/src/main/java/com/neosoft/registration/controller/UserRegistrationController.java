package com.neosoft.registration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.service.IUserRegistrationMgmtService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * The Class UserRegistrationController.
 * 
 * @author Santoshi Yadav
 * 
 */
@RestController
@RequestMapping("/api")
@EnableSwagger2
public class UserRegistrationController {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	/** The service. */
	@Autowired
	IUserRegistrationMgmtService service;
	
	/**
	 * Register user.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PostMapping("/user")
	public User registerUser(@RequestBody User user){
		logger.trace("Request to user registration");
		return service.insertUserData(user);
	}
	
	/**
	 * Update user info.
	 *
	 * @param user the user
	 * @return the string
	 */
	@PutMapping("/user")
	public String updateUserInfo(@RequestBody User user){
		logger.trace("Request to Update record");
		return service.updateUserById(user);
	}

	/**
	 * Get all user.
	 *
	 * @return User list
	 */
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		logger.trace("Request to get All user record");
		return service.findAllUser();
	}
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id){
		logger.trace("Request for get user record by id");
		return service.getByUserId(id);
	}
	
	/**
	 * Gets the user by pincode.
	 *
	 * @param pincode the pincode
	 * @return the user by pincode
	 */
	@GetMapping("/pincode/{pincode}")
	public List<User> getUserByPincode(@PathVariable Integer pincode){
		logger.trace("Request for get user record by pincode");
		return service.getByPincode(pincode);
	}
	
	/**
	 * Gets the users by DOJ.
	 *
	 * @return the users by DOJ
	 */
	@GetMapping("/DOJ")
	public List<User> getUsersByDOJ(){
		logger.trace("Request for get record by order of joining date");
		return service.getAllOrderOfDOJ();
	}
	
	/**
	 * Gets the users by DOB.
	 *
	 * @return the users by DOB
	 */
	@GetMapping("/DOB")
	public List<User> getUsersByDOB(){
		logger.trace("Request for get record by order of birth date");
		return service.getAllOrderOfDOB();
	}
	
	/**
	 * Gets the user by first name.
	 *
	 * @param fname the fname
	 * @return the user by first name
	 */
	@GetMapping("/user/fname")
	public List<User> getUserByFirstName(String fname){
		logger.trace("Request for get record by user first name");
		return service.getByFirstName(fname);
	}
	
	/**
	 * Gets the user by last name.
	 *
	 * @param lname the lname
	 * @return the user by last name
	 */
	@GetMapping("/user/lname")
	public List<User> getUserByLastName(String lname){
		logger.trace("Request for get record by user last name");
		return service.getByLastName(lname);
	}
	
	/**
	 * User temporary deletion.
	 *
	 * @param id the id
	 * @return the string
	 */
	@DeleteMapping("/User/temporary-deletion/{id}")
	public String userTemporaryDeletion(@PathVariable Integer id) {
		logger.trace("Request for soft deletion");
		return service.temporaryUserDeletion(id);
	}
	
	/**
	 * User permanent deletion.
	 *
	 * @param id the id
	 * @return the string
	 */
	@DeleteMapping("/user/permanent-deletion/{id}")
	public String userPermanentDeletion(@PathVariable Integer id) {
		logger.trace("Request for hard deletion");
		return service.permanentUserDeletion(id);
	}
}
