package com.MSBJ.Controller;

import org.springframework.http.HttpStatus;
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

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.WebsiteDto;
import com.MSBJService.WebsiteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/website")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = {"*"},allowedHeaders = {"*"} )

public class WebsiteController {
	private final WebsiteService websiteService;
	
	@PostMapping("/addWebsite")
	public ResponseEntity<Message<WebsiteDto>> addWebsite(@RequestBody WebsiteDto request) {
		log.info("In controller and website() with request: {}",request);
		Message<WebsiteDto> message = websiteService.addWebsite(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@PutMapping("/editWebsite")
	public ResponseEntity<Message<WebsiteDto>> editWebsite(@RequestBody WebsiteDto request) {
		log.info("In controller and website() with request: {}", request);
		Message<WebsiteDto> message = websiteService.editWebsite(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getWebsiteById")
	public ResponseEntity<Message<WebsiteDto>> getWebsiteById(@RequestParam("id") int id) {
		log.info("In controller and website() with request: {}",id);
		Message<WebsiteDto> message = websiteService.getWebsiteById(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getwebsitesBydomain")
	public ResponseEntity<Message<WebsiteDto>> getwebsitesBydomain(@RequestParam("domain") String domain) {
		log.info("In controller and website() with request: {}", domain);
		Message<WebsiteDto> message = websiteService.getwebsitesBydomain(domain);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@DeleteMapping("/deleteWebsite")
	public ResponseEntity<Message<WebsiteDto>> deleteWebsite(@RequestParam("id") int id) {
		log.info("In controller and website() with request:{}", id);
		Message<WebsiteDto> message = websiteService.deleteWebsite(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	
	

}
