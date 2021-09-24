package com.neosoft.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.neosoft.model.User;

/**
 * The Interface IUserRepository.
 * 
 * @author Santoshi Yadav
 * 
 */
public interface IUserRepository extends CrudRepository<User, Long> {
	
    /**
     * Gets the user by username.
     *
     * @param username the username
     * @return the user by username
     */
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
