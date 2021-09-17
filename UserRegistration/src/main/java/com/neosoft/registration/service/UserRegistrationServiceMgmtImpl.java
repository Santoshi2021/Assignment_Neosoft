package com.neosoft.registration.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.exception.InvalidInputException;
import com.neosoft.registration.exception.InvalidUserIdException;
import com.neosoft.registration.exception.RegistrationFailedException;
import com.neosoft.registration.repositry.IUserRegistrationRepo;

/**
 * The Class UserRegistrationServiceMgmtImpl.
 * 
 * @author Santoshi Yadav
 * 
 */
@Service
public class UserRegistrationServiceMgmtImpl implements IUserRegistrationMgmtService {

	/** The Constant STATUS. */
	public final static Integer STATUS = 1; 
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(UserRegistrationServiceMgmtImpl.class);
		
	/** The repo. */
	@Autowired
	IUserRegistrationRepo repo;
	
	/**
	 * Gets the by first name.
	 *
	 * @param fName the first name
	 * @return the by User List
	 */
	
	@Override
	public List<User> getByFirstName(String fName) {
		logger.trace("Gets the by first name");;
		return repo.findByFnameAndIsActive(fName, STATUS);
	}

	/**
	 * Gets the by last name.
	 *
	 * @param lName the last name
	 * @return the by User List
	 */
	
	@Override
	public List<User> getByLastName(String lName) {
		logger.trace("Gets the by last name");
		return repo.findByLnameAndIsActive(lName, STATUS);
	}

	/**
	 * Gets the by pincode.
	 * if pincode is not valid(more than 6 digit),
	 * then it will throw InvalidInputException
	 * @param pincode the pincode
	 * @return the by pincode
	 */
	
	@Override
	public List<User> getByPincode(Integer pincode) {
		logger.trace("Gets the by pincode");
		String regexPincode = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
		if(!String.valueOf(pincode).matches(regexPincode)) {
			logger.error("Invalid Input Exception");
			throw new InvalidInputException();
		}
		return repo.findByPincodeAndIsActive(pincode, STATUS);
	}
	
	/**
	 * Gets the all order of DOB.
	 *
	 * @return the all order of DOB
	 */
	
	@Override
	public List<User> getAllOrderOfDOB(){
		logger.trace("Gets the all order of DOB");
		return repo.findAllOrderByDOBAndIsActive(STATUS);
	}
	
	/**
	 * Gets the all order of DOJ.
	 *
	 * @return the all order of DOJ
	 */
	
	@Override
	public List<User> getAllOrderOfDOJ(){
		logger.trace("Gets the all order of DOJ");
		return repo.findAllOrderByDOJAndIsActive(STATUS);
	}
	
	/**
	 * Gets the by user id.
	 * If User id not found then it will throw Invalid user id exception
	 * @param id the id
	 * @return the by user id
	 */
	
	@Override
	public User getByUserId(String id) {
		String regexId = "^[1-9]{1}[0-9]*$";
		if(!id.matches(regexId)) {
			logger.error("Invalid User Id Exception");
			throw new InvalidUserIdException();
		}			
		return repo.findByIdAndIsActive(Integer.parseInt(id), STATUS);
	}
	
	/**
	 * Find all user.
	 *
	 * @return the list
	 */
	
	@Override
	public List<User> findAllUser() {
		logger.trace("Find all user");
		return repo.findAllIsActive(STATUS);
	}
	
	/**
	 * Temporary user deletion.
	 * If User id not found then it will throw Invalid user id exception
	 * @param id the id
	 * @return the string
	 */
	
	@Override
	public String temporaryUserDeletion(Integer id) {
		logger.trace("Temporary user deletion");
		if(repo.existsById(id)) {
			repo.userRegistrationSoftDeletion(id);
			logger.debug("User registration deactivated");
			return "User registration deactivated";
		}
		logger.error("Invalid User Id Exception");
		throw new InvalidUserIdException();
	}

	/**
	 * Permanent user deletion.
	 * If User id not found then it will throw Invalid user id exception
	 * @param id the id
	 * @return the string
	 */
	
	@Override
	public String permanentUserDeletion(Integer id) {
		logger.trace("Permanent user deletion.");
		if(repo.existsById(id)) {
			repo.deleteById(id);
			logger.debug("User record deleted permanently");
			return "User registration cencelled";
		}
		logger.error("Invalid User Id Exception");
		throw new InvalidUserIdException();
	}

	/**
	 * Insert user data.
	 * if record not inserted into DB,
	 * then it will throw RegistrationFailedException
	 * @param user the user
	 * @return the user
	 */
	
	@Override
	public User insertUserData(User user) {
		logger.trace("Insert user data");
		return Optional.ofNullable(repo.save(user))
				.orElseThrow(() -> {
					throw new RegistrationFailedException();
				});
	}
	
	/**
	 * Update user by id.
	 * If user input data is not valid then,
	 * it will throw InvalidInputException
	 * @param user the user
	 * @return the string
	 */
	
	@Override
	public String updateUserById(User user) {
		if(repo.existsById(user.getId())) {
			String regexEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			String regexPincode = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
			if(user.getEmail().matches(regexEmail) || 
					String.valueOf(user.getAddress().getPincode()).matches(regexPincode)) {
					
				repo.save(user);
				
			}
			else {
				logger.error("Invalid input exception");
				throw new InvalidInputException();
			}
			logger.debug("User data updated");
			return "User data updated";
		}
		logger.error("Invalid user Id exception");
		throw new InvalidUserIdException();
	}

}
