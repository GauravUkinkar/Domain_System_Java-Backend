package com.MSBJ.ServiceImpl;



import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.MSBJ.Dto.LoginRequestDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.UserDto;
import com.MSBJ.Mapper.UserMapper;
import com.MSBJ.Model.User;
import com.MSBJ.Repository.UserRepository;
import com.MSBJ.Util.Constants;
import com.MSBJService.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final UserRepository userRepository;

	@Override
	public Message<UserDto> login(LoginRequestDto request) {
		Message<UserDto> message = new Message<>();
		try {
			User user=userRepository.findByEmail(request.getUsername());
			if(user!=null) {
				if(user.getPassword().equals(request.getPassword())) {
					message.setData(userMapper.toUserDto(user));
					message.setStatus(HttpStatus.OK);
					message.setResponseMessage(Constants.SUCCESS);
					return message;
				}
				else {
					message.setStatus(HttpStatus.BAD_REQUEST);
					message.setResponseMessage(Constants.INVALID_PASSWORD);
					return message;
				}
			}
			else {
				message.setStatus(HttpStatus.BAD_REQUEST);
				message.setResponseMessage(Constants.USER_NOT_FOUND);
				return message;
			}
		} catch (Exception e) {
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			message.setResponseMessage(Constants.SOMETHING_WENT_WRONG);
			return message;
		}
}

	@Override
	public Message<UserDto> registerUser(UserDto request) {
		Message<UserDto> message = new Message<>();
		try {
			
			User user = userMapper.toUser(request);
			User savedUser = userRepository.save(user);
			UserDto savedDto = userMapper.toUserDto(savedUser);
			
			message.setData(savedDto);
			message.setResponseMessage(Constants.REGISTRATION_SUCCESSFULL);
			message.setStatus(HttpStatus.CREATED);
			return message;
		} catch (Exception e) {
			message.setResponseMessage(Constants.INTERNAL_SERVER_ERROR);
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return message;
		}
		
	}
}
