package com.mylab;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylab.cromero.dto.UserRequest;
import com.mylab.cromero.dto.UserResponse;
import com.mylab.cromero.service.BaseService;
import com.mylab.cromero.service.UserService;
import com.mylab.form.UserForm;

@Controller
@RequestMapping("/")
public class WebController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		logger.info("home controller access");
		return "home";
	}

	
	@RequestMapping("/info")
	public String info() {
		logger.info("home controller access");
		return "info";
	}
	

	
	/**
	 * List of all pizzas
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/pizzas")
	public String pizzas(Model model) {

		logger.info("pizzas controller access");
		return "pizzas";
	}
	
	
	/**
	 * List of all users
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/users")
	public String users(Model model) {
		
		logger.info("users controller access");
		List<UserResponse> findAllUsers = userService.findAllUsers();
		model.addAttribute("users", findAllUsers);
		return "users";
	}


	
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		
		logger.info("users controller access");
		UserForm userForm = resetUserForm();
		model.addAttribute("user", userForm);
		return "addUser";
	}

	
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid UserForm user,
			BindingResult result, ModelMap model) {
		this.logger.debug("add user controller ");

		if (result.hasErrors()) {
			return "addUser";
		}
		
	
		UserRequest userRequest = new UserRequest();
		
		userRequest.setAccountNonExpired(user.isAccountNonExpired());
		userRequest.setAccountNonLocked(user.isAccountNonLocked());
		userRequest.setCredentialsNonExpired(user.isCredentialsNonExpired());
		userRequest.setEnabled(user.isEnabled());
		userRequest.setName(user.getName());
		userRequest.setSurname(user.getSurname());
		userRequest.setUser(user.getUser());
		userRequest.setRol(user.getRol());
		userRequest.setPassword(user.getPassword());
		userService.saveUser(userRequest);
		List<UserResponse> findAllUsers = userService.findAllUsers();
		model.addAttribute("users", findAllUsers);
		return "users";
	}
	
	
	
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("login controller access");
		return "login";
	}

	 // Login form with error
    @RequestMapping(value = "/login", params = "error")
    public String loginError(HttpServletRequest req, Model model) {
    	logger.info("login-error: " + req);
        model.addAttribute("loginError", true);
        return "login";
    }
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Locale locale, Model model) {
		logger.info("logout controller access");
		return "login";
	}
       
    

	@ExceptionHandler(Exception.class)
	public void error(Exception exception) {
		exception.printStackTrace();
		logger.info("users {}", exception);
	}
	
	
	private UserForm resetUserForm() {
		UserForm userForm = new UserForm();
		userForm.setRol("ROLE_USER");
		userForm.setAccountNonExpired(true);
		userForm.setAccountNonLocked(true);
		userForm.setCredentialsNonExpired(true);
		userForm.setEnabled(true);
		return userForm;
	}

}
