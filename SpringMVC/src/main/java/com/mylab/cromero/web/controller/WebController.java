package com.mylab.cromero.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.service.BaseService;
import com.mylab.cromero.web.form.BaseForm;

@Controller
@RequestMapping(value = "/")
public class WebController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<BaseResponse> findAllBases = baseService.findAllBases();
		model.addAttribute("findAllBases", findAllBases);
		return "hello";

	}

	@RequestMapping(value = "/addBase", method = RequestMethod.GET)
	public String addContact(ModelMap model) {
		model.addAttribute("base", new BaseForm());
		return "addBase";

	}

	@RequestMapping(value = "/addBase", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("base") @Valid BaseForm base,
			BindingResult result, ModelMap model) {
		this.logger.debug("add base controller ");

		if (result.hasErrors()) {
			return "addBase";
		}
		BaseRequest baseN = new BaseRequest();
		baseN.setName(base.getName());
		baseService.saveBase(baseN);
		List<BaseResponse> findAllBases = baseService.findAllBases();
		model.addAttribute("findAllBases", findAllBases);
		return "hello";
	}

	@ExceptionHandler(Exception.class)
	public String error(Exception exception) {
		exception.printStackTrace();
		logger.error("Generic error");
		return "hello";
	}

}