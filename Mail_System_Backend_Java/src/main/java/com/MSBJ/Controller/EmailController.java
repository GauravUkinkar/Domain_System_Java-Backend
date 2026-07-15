package com.MSBJ.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Dto.Message;
import com.MSBJService.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = {"*"},allowedHeaders = {"*"} )

public class EmailController {
	private final EmailService emailService;
	
	@PostMapping("/addEmail")
	public ResponseEntity<Message<EmailDto>> addEmail(@RequestBody EmailDto request) {
		log.info("In controller and email() with request: {}", request);
		Message<EmailDto> message = emailService.addEmail(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);	
	}
	@PutMapping("/editEmail")
	public ResponseEntity<Message<EmailDto>> editEmail(@RequestBody EmailDto request) {
		log.info("In controller and email() with request: {}", request);
		Message<EmailDto> message = emailService.emailEdit(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getEmailByid")
	public ResponseEntity<Message<EmailDto>> getEmailByid(@RequestParam("id") int id) {
		log.info("In controller and email() with request: {}", id);
		Message<EmailDto> message = emailService.getEmailByid(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getEmailByDomain")
	public ResponseEntity<Message<EmailDto>> getEmailByDomail(@RequestParam("domain") String domain) {
		log.info("In controller and email() with request: {}", domain);
		Message<EmailDto> message = emailService.getEmailByDomain(domain);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@DeleteMapping("/deletEmail")
	public ResponseEntity<Message<EmailDto>> deletEmail(@RequestParam("id") int id) {
		log.info("In controller and email() with request: {}", id);
		Message<EmailDto> message = emailService.deletEmail(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@PostMapping("/addprimary")
	public ResponseEntity<Message<EmailDto>> addprimary(@RequestParam("email") String email) {
		log.info("In controller and email() with request:{}", email);
		Message<EmailDto> message = emailService.addprimary(email);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getAllEmails")
	public ResponseEntity<List<Message<EmailDto>>> getAllEmails(){
		List<Message<EmailDto>> message = emailService.getAllEmails();
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	
	
	

}
