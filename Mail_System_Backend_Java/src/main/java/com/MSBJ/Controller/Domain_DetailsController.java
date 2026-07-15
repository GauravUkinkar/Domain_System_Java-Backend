package com.MSBJ.Controller;

import java.util.List;

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

import com.MSBJ.Dto.Domain_DetailsDto;
import com.MSBJ.Dto.Message;
import com.MSBJService.Domain_DetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/domain_Details")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = {"*"},allowedHeaders = {"*"})

public class Domain_DetailsController {
	private final Domain_DetailsService domain_DetailsService;
	
	@PostMapping("/addDomain")
	public ResponseEntity<Message<Domain_DetailsDto>> addDomain(@RequestBody Domain_DetailsDto request) {
		log.info("In controller and domain() with request: {}", request);
		Message<Domain_DetailsDto> message = domain_DetailsService.addDomain(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getDomainById")
	public ResponseEntity<Message<Domain_DetailsDto>> getDomainById(@RequestParam("id") int id) {
		log.info("In controller and domain() with request: {}", id);
		Message<Domain_DetailsDto> message = domain_DetailsService.getDomainById(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@PutMapping("/editDomain")
	public ResponseEntity<Message<Domain_DetailsDto>> editDomain(@RequestBody Domain_DetailsDto request) {
		log.info("In controller and domain() with request: {}", request);
		Message<Domain_DetailsDto> message = domain_DetailsService.domainEdit(request);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@DeleteMapping("/deleteDomain/{id}")
	public ResponseEntity<Message<Domain_DetailsDto>> deleteDomain(@RequestParam("id") int id) {
		log.info("In controller delete Domain() with id: {}", id);
		Message<Domain_DetailsDto> message = domain_DetailsService.deleteDomain(id);
		HttpStatus httpStatus = HttpStatus.valueOf(message.getStatus().value());
		return ResponseEntity.status(httpStatus).body(message);
	}
	@GetMapping("/getAllDomain")
	public ResponseEntity<List<Message<Domain_DetailsDto>>> getAllDomain(){
		List<Message<Domain_DetailsDto>> message = domain_DetailsService.getAllDomain();
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	

}
