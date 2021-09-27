package com.neosoft.util;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		logger.debug("Loaduser by name: {}", username);
		if (user == null) {
			logger.error("user not found");
			throw new UsernameNotFoundException("Could not find user");
		}
		
		Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));	

		return new org.springframework.security.core.userdetails.User(user.getUsername(),
													user.getPassword(), authorities);
	}

}
