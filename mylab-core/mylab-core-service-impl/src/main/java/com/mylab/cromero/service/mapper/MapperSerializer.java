package com.mylab.cromero.service.mapper;

import java.util.Objects;
import java.util.function.Function;

import com.mylab.cromero.domain.Base;
import com.mylab.cromero.domain.User;
import com.mylab.cromero.dto.BaseResponse;
import com.mylab.cromero.dto.UserRequest;
import com.mylab.cromero.dto.UserResponse;

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
	
	public static Function<User, ? extends UserResponse> getUserToUserResponseMapperLambdaFunction() {
		return user -> {
			UserResponse userResponse = new UserResponse();
			
			userResponse.setAccountNonExpired(user.getAccountNonExpired());
			userResponse.setAccountNonLocked(user.getAccountNonLocked());
			userResponse.setCredentialsNonExpired(user.getCredentialsNonExpired());
			userResponse.setEnabled(user.getEnabled());
			userResponse.setName(user.getName());
			userResponse.setSurname(user.getSurname());
			userResponse.setUser(user.getUser());
			userResponse.setRol(user.getRol());
			return userResponse;
		};
	}
	
	
	
	public static Function<UserRequest, ? extends User> getUserRequestToUserMapperLambdaFunction() {
		return userRequest -> {
			User user = new User();
			
			user.setAccountNonExpired(userRequest.isAccountNonExpired());
			user.setAccountNonLocked(userRequest.isAccountNonLocked());
			user.setCredentialsNonExpired(userRequest.isCredentialsNonExpired());
			user.setEnabled(userRequest.isEnabled());
			user.setName(userRequest.getName());
			user.setSurname(userRequest.getSurname());
			user.setUser(userRequest.getUser());
			user.setRol(userRequest.getRol());
			user.setPassword(userRequest.getPassword());
			return user;
		};
	}
	
	
	
	

}
