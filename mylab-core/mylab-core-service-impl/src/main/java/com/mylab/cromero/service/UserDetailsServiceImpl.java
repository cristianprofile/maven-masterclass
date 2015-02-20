package com.mylab.cromero.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mylab.cromero.dto.UserRequest;
import com.mylab.cromero.service.mapper.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO INCLUDE REPOSITORY SEARCH

		this.logger.debug("Begin operation: searching username :{} ", username);

		if (!(username.equals("admin@ole.com"))) {
			this.logger.info("User authentication error not found :{} ",username);
			throw new UsernameNotFoundException("user login error");
		} else {

			// is an admin user
			UserRequest user = new UserRequest();
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			user.setName("jorge");
			user.setSurname("Romero Matesanz");
			user.setUser("admin@ole.com");
			this.logger.debug("User found correct :{} ", user);
			List<String> roles = Arrays.asList("ROLE_ADMIN");
			return new CustomUserDetails(user, roles, "admin@ole.com");

		}
	}

}
