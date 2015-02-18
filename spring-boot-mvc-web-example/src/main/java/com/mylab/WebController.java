package com.mylab;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylab.cromero.service.BaseService;

@Controller
@RequestMapping("/")
public class WebController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		logger.info("home controller access");
		return "home";
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
		logger.info("logoutttt controller access");
		return "login";
	}

	@ExceptionHandler(Exception.class)
	public void error(Exception exception) {
		exception.printStackTrace();
		logger.info("users {}", exception);
	}

}
