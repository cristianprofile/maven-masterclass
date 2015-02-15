package com.mylab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mylab.cromero.service.BaseService;

@RestController
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
		logger.info("home controller mapping");
		return "home";
	}

}
