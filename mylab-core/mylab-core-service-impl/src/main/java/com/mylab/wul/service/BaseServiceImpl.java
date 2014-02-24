package com.mylab.wul.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.wul.domain.Base;
import com.mylab.wul.domain.Pizza;
import com.mylab.wul.dto.BaseRequest;
import com.mylab.wul.dto.BaseResponse;
import com.mylab.wul.exception.BaseNotFoundException;
import com.mylab.wul.repository.BaseRepository;


@Service
@Transactional
public class BaseServiceImpl implements BaseService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    BaseRepository baseRepository;


	public void deleteBase(BaseRequest base) throws BaseNotFoundException{
		this.logger.debug("Begin operation: deleteBase, request:{} ", base);
		
		List<Base> findByNameContaining = baseRepository.findByName(base.getName());
		if (findByNameContaining.isEmpty())
		{
			throw new BaseNotFoundException("No se ha encontrado ninguna base con ese nombre");
		}
        baseRepository.delete(findByNameContaining.get(0).getId());
        
        this.logger.debug("End operation: deleteBase ");
    }

	public List<BaseResponse> findAllBases() {
		this.logger.debug("Begin operation: findAllBases ");
		List<BaseResponse> listBases = new ArrayList<BaseResponse>();
		List<Base> findAll = baseRepository.findAll();
		for (Base base : findAll) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setName(base.getName());
			listBases.add(baseResponse);
		}
		this.logger.debug("End operation: findAllBases {} ",listBases);
        return listBases;
    }

	public void saveBase(BaseRequest base) {
		this.logger.debug("Begin operation: save request:{} ", base);
		Base baseAlmacenar = new Base();
		baseAlmacenar.setName(base.getName());
        baseRepository.save(baseAlmacenar);
        this.logger.debug("End operation: save request:{} ", base);
    }


}
