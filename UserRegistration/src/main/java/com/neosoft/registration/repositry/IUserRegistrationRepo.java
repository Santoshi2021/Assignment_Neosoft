package com.neosoft.registration.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.registration.entity.User;
/**
 * The Interface IUserRegistrationRepo.
 * 
 * @author Santoshi Yadav
 * 
 */
@Repository
public interface IUserRegistrationRepo extends JpaRepository<User, Integer> {
	
	/**
	 * Find by first name and by active status.
	 *
	 * @param fName the fisrt name
	 * @param isActive the active status
	 * @return the list
	 */
	public List<User> findByFnameAndIsActive(String fName, Integer isActive);
	
	/**
	 * Find by last name and by active status.
	 *
	 * @param lName the last name
	 * @param isActive the active status
	 * @return the list
	 */
	public List<User> findByLnameAndIsActive(String lName, Integer isActive);
	
	/**
	 * Find by id and is active.
	 *
	 * @param id the id
	 * @param isActive the active status
	 * @return the user
	 */
	public User findByIdAndIsActive(Integer id, Integer isActive);
	
	/**
	 * Find all order by DOB and active status. 
	 *
	 * @param isActive the active status
	 * @return the list
	 */
	@Query("from User where isActive = :isActive order by dob desc")
	public List<User> findAllOrderByDOBAndIsActive(Integer isActive);
	
	/**
	 * Find all order by DOJ and active status.
	 *
	 * @param isActive the active status
	 * @return the list
	 */
	@Query("from User where isActive = :isActive order by dob desc")
	public List<User> findAllOrderByDOJAndIsActive(Integer isActive);
	
	/**
	 * User registration soft deletion.
	 *
	 * @param id the id
	 */
	@Modifying
	@Transactional
	@Query("update User U SET U.isActive = 0 WHERE id = :id")
	public void userRegistrationSoftDeletion(Integer id);
	
	/**
	 * Find all is active.
	 *
	 * @param isActive the active status
	 * @return the list
	 */
	@Query("select u from User u where isActive = :isActive")
	public List<User> findAllIsActive(Integer isActive);
	
	/**
	 * Find by pincode and active status.
	 *
	 * @param pincode the pincode
	 * @param isActive the active status
	 * @return the list
	 */
	@Query("select u from User u where u.address.pincode = :pincode and isActive = :isActive")
	public List<User> findByPincodeAndIsActive(Integer pincode, Integer isActive);
	
}
