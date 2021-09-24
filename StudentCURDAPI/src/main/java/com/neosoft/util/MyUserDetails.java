package com.neosoft.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.neosoft.model.Role;
import com.neosoft.model.User;

/**
 * The Class MyUserDetails.
 * 
 * @author Santoshi Yadav
 * 
 */
public class MyUserDetails implements UserDetails {
	 
    /** The user. */
    private User user;
    
    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(MyUserDetails.class); 
    
    /**
     * Instantiates a new my user details.
     *
     * @param user the user
     */
    public MyUserDetails(User user) {
    	logger.debug("MyUserDetails constructor::"+user);
    	this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        logger.debug("Set of roles:: "+roles);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
 
}