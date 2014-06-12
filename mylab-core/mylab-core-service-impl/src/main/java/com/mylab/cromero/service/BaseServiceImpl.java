package com.mylab.cromero.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.cromero.domain.Base;
import com.mylab.cromero.dto.BaseRequest;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.exception.BaseNotFoundException;
import com.mylab.cromero.repository.BaseRepository;
import com.mylab.cromero.service.BaseService;

/**
* <h1>Base Service Implement!</h1>
* Bussiness Service example using repository access. 
* <p>
* <b>Base</b> Access to Base Pizza Example model object using
* repositories with spring data jpa
*
* @author  Cristian Romero Matesanz
*
* 
*/

@Service
@Transactional
public class BaseServiceImpl implements BaseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRepository baseRepository;
    
    
    @Override
    public void deleteBase(final BaseRequest base) throws BaseNotFoundException {
        this.logger.debug("Begin operation: deleteBase, request:{} ", base);

        List<Base> findByNameContaining = baseRepository.findByName(base.getName());
        if (findByNameContaining.isEmpty()){
            throw new BaseNotFoundException("No se ha encontrado ninguna base con ese nombre");
        }
        baseRepository.delete(findByNameContaining.get(0).getId());

        this.logger.debug("End operation: deleteBase ");
    }

    @Override
    public List<BaseResponse> findAllBases() {
        this.logger.debug("Begin operation: findAllBases ");
        List<BaseResponse> listBases = new ArrayList<BaseResponse>();
        List<Base> findAll = baseRepository.findAll();
        for (Base base : findAll) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setName(base.getName());
            listBases.add(baseResponse);
        }
        this.logger.debug("End operation: findAllBases {} ", listBases);
        return listBases;
    }

    @Override
    public void saveBase(final BaseRequest base) {
        this.logger.debug("Begin operation: save request:{} ", base);
        Base baseAlmacenar = new Base();
        baseAlmacenar.setName(base.getName());
        baseRepository.save(baseAlmacenar);
        this.logger.debug("End operation: save request:{} ", base);
    }

}
