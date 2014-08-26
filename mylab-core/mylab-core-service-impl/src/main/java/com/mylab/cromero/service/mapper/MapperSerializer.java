package com.mylab.cromero.service.mapper;

import java.util.Objects;
import java.util.function.Function;

import com.mylab.cromero.domain.Base;
import com.mylab.cromero.dto.BaseResponse;

public class MapperSerializer {

	public static BaseResponse serializeObject(Base base) {
		Base requireNonNull = Objects.requireNonNull(base);
		return MapperSerializer.getBaseToBaseResponseMapperLambdaFunction().apply(requireNonNull);
		
	}

	public static Function<Base, ? extends BaseResponse> getBaseToBaseResponseMapperLambdaFunction() {
		return base -> {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setName(base.getName());
			baseResponse.setId(base.getId());
			return baseResponse;
		};
	}
	

}
