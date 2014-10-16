package com.mylab.cromero.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.cromero.domain.Base;
import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.exception.BaseNotFoundException;
import com.mylab.cromero.repository.BaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class BaseServiceImplTest {

	@InjectMocks
	private BaseServiceImpl baseService;

	@Mock
	private BaseRepository baseRepository;
	
	

    @Test(expected = BaseNotFoundException.class)
    public void testDeleteBaseNotExist() {
    	
    	//create empty repository list to return when i call to findbyname method
    	List<Base> listaBasesRepositorio=new ArrayList<Base>();
    	when(this.baseRepository.findByName("margarita")).thenReturn(listaBasesRepositorio);
        BaseRequest base = new BaseRequest();
        base.setName("margarita");
        baseService.deleteBase(base);
       

    }

    @Test
    public void testDeleteBaseOk() {
    	List<Base> listaBasesRepositorio=new ArrayList<Base>();
    	Base base2 = new Base();
    	base2.setId(33L);
    	base2.setName("margarita");
    	listaBasesRepositorio.add(base2);
    	when(this.baseRepository.findByName("margarita")).thenReturn(listaBasesRepositorio);
        BaseRequest base = new BaseRequest();
        base.setName("margarita");
        baseService.saveBase(base);
        //save must be called once time
        verify(this.baseRepository, times(1)).save(any(Base.class));
        baseService.deleteBase(base);
        //delete must be called once time with base 2 id
        verify(this.baseRepository, times(1)).delete(base2.getId());
        
        
        
    }
	
	
	

}
