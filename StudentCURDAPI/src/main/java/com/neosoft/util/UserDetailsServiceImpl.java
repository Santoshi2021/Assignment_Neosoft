package com.neosoft.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.neosoft.model.User;

import com.neosoft.repository.IUserRepository;

/**
 * The Class UserDetailsServiceImplementation.
 * 
 * @author Santoshi Yadav
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	/** The user repository. */
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		logger.debug("Loaduser by name:" + username);
		if (user == null) {
			logger.error("user not found exception");
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

}
