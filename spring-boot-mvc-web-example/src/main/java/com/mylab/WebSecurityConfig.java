package com.mylab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/pizzas","/info").hasAnyRole("USER","ADMIN").and()
		.authorizeRequests().antMatchers("/users","/addUser").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/static/**","/logout","/login").permitAll();
		
	    http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll();
		
		http.logout().logoutSuccessUrl("/").deleteCookies("remember-me").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication().withUser("user@ole.com").password("user@ole.com")
//		.roles("USER");
//		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
