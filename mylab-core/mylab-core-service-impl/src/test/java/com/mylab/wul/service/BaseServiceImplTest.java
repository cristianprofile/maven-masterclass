package com.mylab.wul.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.wul.dto.BaseRequest;
import com.mylab.wul.exception.BaseNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext-service-test.xml")
public class BaseServiceImplTest {
	
	 @Autowired
	 private BaseService baseService;
	
	@Transactional
    @Test(expected = BaseNotFoundException.class)
    public void testDeleteBaseNotExist() {
       
		BaseRequest base=new BaseRequest();
		base.setName("margarita");
		baseService.deleteBase(base);

    }
	
	@Transactional
    @Test
    public void testDeleteBaseOk() {
		
		BaseRequest base=new BaseRequest();
		base.setName("margarita");
		baseService.saveBase(base);
		Assert.assertEquals(baseService.findAllBases().size(), 1);
		baseService.deleteBase(base);
        Assert.assertEquals(baseService.findAllBases().size(), 0);
    }

}
