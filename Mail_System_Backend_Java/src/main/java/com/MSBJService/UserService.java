package com.MSBJService;

import com.MSBJ.Dto.LoginRequestDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.UserDto;

public interface UserService {
	
	public Message<UserDto>login(LoginRequestDto request);
	public Message<UserDto>registerUser(UserDto request);

	

}
