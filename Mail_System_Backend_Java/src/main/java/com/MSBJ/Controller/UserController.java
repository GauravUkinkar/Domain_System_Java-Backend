package com.MSBJ.Controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MSBJ.Dto.LoginRequestDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.UserDto;
import com.MSBJService.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})

public class UserController {
	private final UserService userService;
	
	@PostMapping("/Login")
	public ResponseEntity<Message<UserDto>> loginUser(@RequestBody LoginRequestDto request) {
		Message<UserDto> message = userService.login(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
		
	}
	@PostMapping("/register")
	public ResponseEntity<Message<UserDto>> registerUser(@RequestBody UserDto dto) {
		Message<UserDto> message = userService.registerUser(dto);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}

}
