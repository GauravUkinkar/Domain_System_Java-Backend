package com.MSBJ.ServiceImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final UserRepository userRepository;

	@Override
	public Message<UserDto> login(LoginRequestDto request) {
		Message<UserDto> message = new Message<>();
		User user = null;
		UserDto userDto = null;
		try {
			user = userRepository.getByUsernameAndPassword(request.getUsername(),request.getPassword());
			if (user != null) {
				message.setStatus(HttpStatus.NOT_FOUND);
				message.setResponseMessage(Constants.RECORD_NOT_FOUND);
				log.info(Constants.RECORD_NOT_FOUND);
				return message;
			}
		}
		
	}

}
