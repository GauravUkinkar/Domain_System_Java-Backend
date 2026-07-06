package com.MSBJ.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.SubDomainListDto;
import com.MSBJ.ServiceImpl.SubDomainListServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping()
@Log4j2
@RequiredArgsConstructor
public class SubDomainListController {
	
	private final SubDomainListServiceImpl subDomainListServiceImpl;
	
	@PostMapping("/addSubdomain")
	public ResponseEntity<Message<SubDomainListDto>> addEmployee(@RequestBody SubDomainListDto request){
		log.info("In controller add Subdomain() with request: {}", request);
		Message<SubDomainListDto> response = subDomainListServiceImpl.addSubdomain(request);
		return new ResponseEntity<Message<SubDomainListDto>>(response, response.getStatus());
	}
	
	@GetMapping("/getsubdomainBYId")
	public ResponseEntity<Message<SubDomainListDto>> getsubdomainBYId(@RequestParam("id") int id){
		Message<SubDomainListDto> response = subDomainListServiceImpl.getsubdomainBYId(id);
		HttpStatus httpStatus = HttpStatus.valueOf(response.getStatus().value());
		return ResponseEntity.status(httpStatus).body(response);
	}
	
	@PutMapping("/editSubdomain")
	public ResponseEntity<Message<SubDomainListDto>> editSubdomain(@RequestBody SubDomainListDto request){
		log.info("In controller edit Subdomain() with request: {}", request);
	    Message<SubDomainListDto> response = subDomainListServiceImpl.editSubdomain(request);
	    HttpStatus httpStatus = HttpStatus.valueOf(response.getStatus().value());
	    return ResponseEntity.status(httpStatus).body(response);			
	}
	
	@DeleteMapping("/deleteSubdomain/{id}")
	public ResponseEntity<Message<SubDomainListDto>> deleteSubdomain(@PathVariable int id){
		log.info("In controller deletesubdomain() with id: {}", id);
		Message<SubDomainListDto> response = subDomainListServiceImpl.deleteSubdomain(id);
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	
}
