package com.MSBJ.Mapper;

import com.MSBJ.Dto.UserDto;
import com.MSBJ.Model.User;

public interface UserMapper {
	public UserDto toUserDto(User user);
	public User toUser(UserDto userDto);
	

}
