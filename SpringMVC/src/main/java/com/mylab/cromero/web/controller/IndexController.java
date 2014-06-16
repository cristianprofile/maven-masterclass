package com.mylab.cromero.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.service.BaseService;
import com.mylab.cromero.web.form.BaseForm;

import flexjson.JSONSerializer;

@Controller
@RequestMapping(value = "/")
public class IndexController {

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
	public ResponseEntity<String> verIngredientes() {
		BaseRequest base = new BaseRequest();
		base.setName("margarita");
		baseService.saveBase(base);
		base = new BaseRequest();
		base.setName("masa-pan");
		
		baseService.saveBase(base);
		List<BaseResponse> findAllBases = baseService.findAllBases();
		JSONSerializer serializer = new JSONSerializer();
		String serialize = serializer.exclude("*.class").serialize(findAllBases);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8"); 
		return new ResponseEntity<String>(serialize, headers, HttpStatus.OK);

	}
	
	
	
	
	 @RequestMapping(value = "/addBase", method = RequestMethod.GET)
	    public String addContact(ModelMap model) {
	         model.addAttribute("base", new BaseForm());
		 return "addBase";
	         
	    
	    }
	     
	
	
	 @RequestMapping(value = "/addBase", method = RequestMethod.POST)
	    public String addContact(@ModelAttribute("base")
	    BaseForm base, BindingResult result,ModelMap model) {
		 BaseRequest baseN = new BaseRequest();
		 baseN.setName(base.getName());
		 baseService.saveBase(baseN);
		 List<BaseResponse> findAllBases = baseService.findAllBases();
		 model.addAttribute("findAllBases", findAllBases);
	     return "hello";
	    }
	     

	

}