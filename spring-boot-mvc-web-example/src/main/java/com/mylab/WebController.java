package com.mylab;

import java.util.Locale;

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
		logger.info("haciendo mi pryeba");
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public String loginWithError(Locale locale, Model model) {
		model.addAttribute("error", true);
		return "login";
	}

	@ExceptionHandler(Exception.class)
	public void error(Exception exception) {
		exception.printStackTrace();
		logger.info("users {}", exception);
	}

}
