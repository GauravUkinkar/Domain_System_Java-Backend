package com.MSBJ.MapperImpl;

import org.springframework.stereotype.Component;

import com.MSBJ.Dto.UserDto;
import com.MSBJ.Mapper.UserMapper;
import com.MSBJ.Model.User;

@Component

public class UserMapperImpl implements UserMapper {

	@Override
	public UserDto toUserDto(User user) {
		return new UserDto().
				setId(user.getId()).
				setUsername(user.getUsername()).
				setPassword(user.getPassword()).
				setCreatedAt(user.getCreatedAt());
		
	}

	@Override
	public User toUser(UserDto userDto) {
		return new User()
				.setId(userDto.getId())
				.setUsername(userDto.getUsername())
				.setPassword(userDto.getPassword())
				.setCreatedAt(userDto.getCreatedAt());
		
		
	}

}
