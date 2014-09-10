package com.mylab.cromero.service.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.cromero.domain.Base;
import com.mylab.cromero.dto.BaseResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext-service-test.xml")
public class MapperSerializerTest {
   

    @Test(expected = NullPointerException.class)
    public void testDeleteBaseNotExist() {

        MapperSerializer.serializeObject(null);

    }
    
    @Test
    public void testDeleteBaseOk() {
     Base base = new Base();
     base.setId(1L);
     base.setName("margarita");
     base.setVersion(1);
     BaseResponse serializeObject = MapperSerializer.serializeObject(base);
     Assert.assertTrue(serializeObject.getName().equalsIgnoreCase("margarita"));
     Assert.assertTrue(serializeObject.getId()==1);

    }

  

}
