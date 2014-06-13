package com.mylab.cromero.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.service.BaseService;

import flexjson.*;

@Controller
@RequestMapping("/welcome")
public class IndexController {

	@Autowired
	private BaseService baseService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
	
		BaseRequest base = new BaseRequest();
		base.setName("rolling pizza");
		baseService.saveBase(base);
		base = new BaseRequest();
		base.setName("masa-pan");
		baseService.saveBase(base);
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

}