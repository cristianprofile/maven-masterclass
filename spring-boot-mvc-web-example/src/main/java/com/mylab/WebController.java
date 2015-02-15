package com.mylab;

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
@RequestMapping("/base")
public class WebController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;

	/**
	 * Home
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		logger.info("home controller mapping test");
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

		logger.info("users");
		return "users";
	}
	
	
	@ExceptionHandler(Exception.class)
	public void error(Exception exception) {
		exception.printStackTrace();
		logger.info("users {}",exception);
	}

}
