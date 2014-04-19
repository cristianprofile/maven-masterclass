package com.mylab.wul.service;

import java.util.List;

import com.mylab.wul.dto.BaseRequest;
import com.mylab.wul.dto.BaseResponse;
import com.mylab.wul.exception.BaseNotFoundException;

public interface BaseService {

    public abstract void deleteBase(BaseRequest base) throws BaseNotFoundException;

    public abstract List<BaseResponse> findAllBases();

    public abstract void saveBase(BaseRequest base);

}
