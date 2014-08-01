package com.mylab.cromero.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.exception.BaseNotFoundException;
import com.mylab.cromero.service.BaseService;


@RestController
@RequestMapping(value = "/base")
public class RestExampleController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseService baseService;


	

	@RequestMapping(method = RequestMethod.GET)
	public List<BaseResponse> listAllBase() {
		List<BaseResponse> findAllBases = baseService.findAllBases();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8"); 
		return findAllBases;

	}
	
	@RequestMapping(value="/{baseId}", method=RequestMethod.GET)
	public BaseResponse getBase(@PathVariable("baseId") long id) {
		BaseResponse base = baseService.getBase(id);
		return base;
	}

	
	@RequestMapping(value="/{baseId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBase(@PathVariable("baseId") long id) {
		baseService.deleteBase(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public void insertBase(@RequestBody BaseRequest newBase) {
    
		BaseRequest base=new BaseRequest();
		base.setName(newBase.getName());
		baseService.saveBase(base);
	
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
	public void updateBase(@RequestBody BaseRequest base) {		
		
		BaseRequest baseUpdate=new BaseRequest();
		baseUpdate.setId(base.getId());
		baseUpdate.setName(base.getName());
		baseService.updateBase(baseUpdate);
	
	
	}
	
	
	  // Convert a predefined exception to an HTTP Status code Not Found
	  @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Base not found") 
	  @ExceptionHandler(BaseNotFoundException.class)
	  public void notFound() {
		  logger.info("pizza base doesn`t exist");
	  }

	  
	  @ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE, reason="service not available") 
	  @ExceptionHandler(Exception.class)
	  public void error(Exception exception) { exception.printStackTrace();
		  logger.error("Generic error",exception);
	  }


	




}