package com.mylab.cromero.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.service.BaseService;
import com.mylab.cromero.web.form.BaseForm;



@Controller
@RequestMapping(value = "/")
public class IndexController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;


	@RequestMapping( method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {


		List<BaseResponse> findAllBases = baseService.findAllBases();
		model.addAttribute("findAllBases", findAllBases);
		return "hello";

	}

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	@ResponseBody
	public List<BaseResponse> verIngredientes() {
		BaseRequest base = new BaseRequest();
		base.setName("margarita");
		baseService.saveBase(base);
		base = new BaseRequest();
		base.setName("masa-pan");

		baseService.saveBase(base);
		List<BaseResponse> findAllBases = baseService.findAllBases();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8"); 
		return findAllBases;

	}




	 @RequestMapping(value = "/addBase", method = RequestMethod.GET)
	    public String addContact(ModelMap model) {
	         model.addAttribute("base", new BaseForm());
		 return "addBase";


	    }



	 @RequestMapping(value = "/addBase", method = RequestMethod.POST)
	    public String addContact(@ModelAttribute("base")
	    BaseForm base, BindingResult result,ModelMap model) {
		 this.logger.debug("add base controller ");
		 BaseRequest baseN = new BaseRequest();
		 baseN.setName(base.getName());
		 baseService.saveBase(baseN);
		 List<BaseResponse> findAllBases = baseService.findAllBases();
		 model.addAttribute("findAllBases", findAllBases);
	     return "hello";
	    }




}