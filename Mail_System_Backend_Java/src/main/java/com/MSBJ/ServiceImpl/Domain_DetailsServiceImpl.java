package com.MSBJ.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.MSBJ.Dto.Domain_DetailsDto;
import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Mapper.Domain_DetailsMapper;
import com.MSBJ.Model.Domain_Details;
import com.MSBJ.Repository.Domain_DetailsRepository;
import com.MSBJ.Util.Constants;
import com.MSBJService.Domain_DetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

public class Domain_DetailsServiceImpl implements Domain_DetailsService {
	
	private final Domain_DetailsMapper domain_DetailsMapper;
	private final Domain_DetailsRepository domain_DetailsRepository;
	
	
	@Override
	public Message<Domain_DetailsDto> addDomain(Domain_DetailsDto request) {
		Message<Domain_DetailsDto> response = new Message<>();
		
		try {
			if (request == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				return response;
			}
			
			Domain_Details domain_Details = new Domain_Details();
			domain_Details = domain_DetailsMapper.toDomain_Details(request);
			domain_DetailsRepository.save(domain_Details);
			Domain_DetailsDto dto = domain_DetailsMapper.toDomain_DetailsDto(domain_Details);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.DOMAIN_ADDED_SUCCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<Domain_DetailsDto> getDomainById(int id) {
		Message<Domain_DetailsDto> response = new Message<>();
		
		try {
			Domain_Details domain_Details = domain_DetailsRepository.getById(id);
			
			if (domain_Details == null) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.DOMAIN_NOT_FOUND);
				return response;
			}
			Domain_DetailsDto dto = domain_DetailsMapper.toDomain_DetailsDto(domain_Details);
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.DOMAIN_FETCH_SUCCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<Domain_DetailsDto> domainEdit(Domain_DetailsDto request) {
		Message<Domain_DetailsDto> response = new Message<>();
		try {
			if (request == null || request.getId() == 0) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				return response;
			}
			Domain_Details domain_Details = domain_DetailsRepository.getById(request.getId());
			
			if (domain_Details == null) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.DOMAIN_NOT_FOUND);
				return response;
			}
			domain_Details.setCreatedAt(request.getCreatedAt());
			domain_Details.setDomain(request.getDomain());
			domain_Details.setExpiryDate(request.getExpiryDate());
			domain_Details.setExpiryStatus(request.getExpiryStatus());
			domain_Details.setId(request.getId());
			domain_Details.setPassword(request.getPassword());
			domain_Details.setPlatformUrl(request.getPlatformUrl());
			domain_Details.setPurchaseDate(request.getPurchaseDate());
			domain_Details.setPurchasePlatform(request.getPurchasePlatform());
			domain_Details.setUsername(request.getUsername());
			
			domain_DetailsRepository.save(domain_Details);
			Domain_DetailsDto dto = domain_DetailsMapper.toDomain_DetailsDto(domain_Details);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.DOMAIN_UPDATED_SUCCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<Domain_DetailsDto> deleteDomain(int id) {
		Message<Domain_DetailsDto> response = new Message<>();
		
		try {
			Optional<Domain_Details> domain_Details = domain_DetailsRepository.findById(id);
			
			if (!domain_Details.isPresent()) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.DOMAIN_NOT_FOUND);
				return response;
			}
			domain_DetailsRepository.deleteById(id);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.DOMAIN_DELETED_SUCCESSFULLY);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
			
		}
		
	}

	@Override
	public List<Message<Domain_DetailsDto>> getAllDomain() {
		List<Message<Domain_DetailsDto>> message = new ArrayList<>();
		try {
			List<Domain_Details> domainDetails = domain_DetailsRepository.findAll();
			if (domainDetails.isEmpty()) {
				message.add(new Message<>(HttpStatus.BAD_REQUEST,Constants.DOMAIN_NOT_FOUND, null));
				return message;
			}
			for (Domain_Details domaindetails : domainDetails) {
				Domain_DetailsDto dto = domain_DetailsMapper.toDomain_DetailsDto(domaindetails);
				log.info("In Domain_DetailsService getAllDomain() with response: {}", dto);
				message.add(new Message<>(
						HttpStatus.OK,
						"Domain Found Successfull",
						dto
						));
			}
		} catch (Exception e) {
			message.add(new Message<>(
					HttpStatus.INTERNAL_SERVER_ERROR,
					Constants.SOMETHING_WENT_WRONG +e.getMessage(),
					null
					));
		}
		return message;
	}

}
