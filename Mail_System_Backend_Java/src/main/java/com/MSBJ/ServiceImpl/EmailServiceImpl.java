package com.MSBJ.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Mapper.EmailMapper;
import com.MSBJ.Model.Domain_Details;
import com.MSBJ.Model.Email;
import com.MSBJ.Repository.Domain_DetailsRepository;
import com.MSBJ.Repository.EmailRepository;
import com.MSBJ.Util.Constants;
import com.MSBJService.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

public class EmailServiceImpl implements EmailService {
	
	private final EmailMapper emailMapper;
	private final EmailRepository emailRepository;
	private final Domain_DetailsRepository domain_DetailsRepository;

	@Override
	public Message<EmailDto> addEmail(EmailDto request) {
		Message<EmailDto> response = new Message<>();
		
		try {
			if (request == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				return response;
			}
			
			Email email = new Email(); 
			email = emailMapper.toEmail(request);
			emailRepository.save(email);
			EmailDto dto = emailMapper.toEmailDto(email);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.EMAIL_ADDED_SUCCESSFULLY);
			response.setData(dto);
			return response;
			
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	
	
	
	
	@Override
	public Message<EmailDto> emailEdit(EmailDto request) {
		Message<EmailDto> response = new Message<>();
		try {
			if (request == null || request.getId() == 0) { 
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				
			}
			Email email =emailRepository.getById(request.getId());
			if(email == null) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.EMAIL_NOT_FOUND);
				return response;
				
			}
			email.setCreatedAt(request.getCreatedAt());
			email.setDomainId(request.getDomainId());
			email.setEmail(request.getEmail());
			email.setId(request.getId());
			email.setPassword(request.getPassword());
			email.setPlatform(request.getPlatform());
			email.setPrimaryTag(request.getPrimaryTag());
			email.setStatus(request.getStatus());
			email.setUsername(request.getUsername());
			
		    emailRepository.save(email);
			EmailDto dto = emailMapper.toEmailDto(email);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.EMAIL_UPDATED_SUCCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<EmailDto> getEmailByid(int id) {
		Message<EmailDto> response = new Message<>();
		
		try {
			Email email = emailRepository.getById(id);
			
			if (email == null) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.EMAIL_NOT_FOUND);
				return response;
			}
			EmailDto dto = emailMapper.toEmailDto(email);
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.EMAIL_FETCH_SUCCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<EmailDto> getEmailByDomain(String domain) {

	    Message<EmailDto> response = new Message<>();

	    try {

	        Domain_Details domainDetails = domain_DetailsRepository.getByDomain(domain);

	        if (domainDetails == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.DOMAIN_NOT_FOUND);
	            return response;
	        }

	        Email email = emailRepository.getByDomainId(domainDetails.getId());

	        if (email == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.EMAIL_NOT_FOUND);
	            return response;
	        }

	        EmailDto dto = emailMapper.toEmailDto(email);

	        response.setStatus(HttpStatus.OK);
	        response.setResponseMessage(Constants.EMAIL_FETCH_SUCCESSFULLY);
	        response.setData(dto);

	    } catch (Exception e) {

	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        response.setResponseMessage("Error: " + e.getMessage());

	    }

	    return response;
	}

	@Override
	public Message<EmailDto> deletEmail(int id) {
		Message<EmailDto> response = new Message<>();
		
		try {
			Optional<Email> email = emailRepository.findById(id);
			
			if (!email.isPresent()) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.EMAIL_NOT_FOUND);
				return response;
			}
			emailRepository.deleteById(id);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.EMAIL_DELETED_SUCCESSFULLY);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
			
		}
		
	}

	@Override
	public Message<EmailDto> addprimary(String email) {

	    Message<EmailDto> response = new Message<>();

	    try {

	        if (email == null || email.trim().isEmpty()) {
	            response.setStatus(HttpStatus.BAD_REQUEST);
	            response.setResponseMessage(Constants.INVALID_INPUT_DATA);
	            return response;
	        }

	        Email emailEntity = new Email();
	        emailEntity.setEmail(email);

	        emailRepository.save(emailEntity);

	        EmailDto dto = emailMapper.toEmailDto(emailEntity);

	        response.setStatus(HttpStatus.OK);
	        response.setResponseMessage("Email added successfully.");
	        response.setData(dto);

	    } catch (Exception e) {
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        response.setResponseMessage("Error: " + e.getMessage());
	    }

	    return response;
	}
	@Override
	public List<Message<EmailDto>> getAllEmails() {
	    List<Message<EmailDto>> message = new ArrayList<>();
	    try {
	        List<Email> emails = emailRepository.findAll();
	        if (emails.isEmpty()) {
	            message.add(new Message<>(HttpStatus.BAD_REQUEST, Constants.EMAIL_NOT_FOUND, null));
	            return message;
	        }
	        for (Email email : emails) {
	            EmailDto dto = emailMapper.toEmailDto(email);
	            log.info("In EmailService getAllEmails() with response: {}", dto);
	            message.add(new Message<>(
	                    HttpStatus.OK,
	                    "Email found successfully.",
	                    dto
	            ));
	        }
	    } catch (Exception e) {
	        message.add(new Message<>(
	                HttpStatus.INTERNAL_SERVER_ERROR,
	                Constants.SOMETHING_WENT_WRONG + e.getMessage(),
	                null
	        ));
	    }
	    return message;
	}
}
