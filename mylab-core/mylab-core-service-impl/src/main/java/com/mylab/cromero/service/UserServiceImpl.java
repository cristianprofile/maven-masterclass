package com.mylab.cromero.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mylab.cromero.dto.User;
import com.mylab.cromero.service.mapper.CustomUserDetails;

@Service
public class UserServiceImpl implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO INCLUDE REPOSITORY SEARCH

		this.logger.debug("Begin operation: searching username :{} ", username);
		
		if (!username.equals("user@ole.com")) {
			this.logger.info("User authentication error not found :{} ", username);
			throw new UsernameNotFoundException("user login error");
		} else {
			User user = new User();
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			user.setName("cristian");
			user.setSurname("Romero Matesanz");
			user.setUser("user@ole.com");
			this.logger.debug("User found correct :{} ", user);
			//important if you add a role you have to add role_ and name of role created at 
			//spring security config 
			//TODO READ MORE ABOUT ROLE AND ACCESS PERMISSION IN SPRING SECURITY
			List<String> roles = Arrays.asList("ROLE_USER","ROLE_USER");
			return new CustomUserDetails(user, roles, "user@ole.com");
		}
	}

}
