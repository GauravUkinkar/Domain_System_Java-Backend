package com.MSBJ.ServiceImpl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.WebsiteDto;
import com.MSBJ.Mapper.WebsiteMapper;
import com.MSBJ.Model.Domain_Details;
import com.MSBJ.Model.Website;
import com.MSBJ.Repository.Domain_DetailsRepository;
import com.MSBJ.Repository.WebsiteRepository;
import com.MSBJ.Util.Constants;
import com.MSBJService.WebsiteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

public class WebsiteServiceImpl implements WebsiteService {
	
	private final WebsiteMapper websiteMapper;
	private final WebsiteRepository websiteRepository;
	private final Domain_DetailsRepository domain_DetailsRepository;
	
	@Override
	public Message<WebsiteDto> addWebsite(WebsiteDto request) {
		Message<WebsiteDto> response = new Message<>();
		
		try {
			if (request == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				return response;
			}
			
			Website website = new Website();
			website = websiteMapper.toWebsite(request);
			websiteRepository.save(website);
			WebsiteDto dto = websiteMapper.toWebsiteDto(website);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.WEBSITE_ADDED_SUCCESSFULLY);
			response.setData(dto);
			return response;
			
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

	@Override
	public Message<WebsiteDto> editWebsite(WebsiteDto request) {
	    Message<WebsiteDto> response = new Message<>();

	    try {
	        if (request == null || request.getId() == 0) {
	            response.setStatus(HttpStatus.BAD_REQUEST);
	            response.setResponseMessage(Constants.INVALID_INPUT_DATA);
	            return response;
	        }

	        Website website = websiteRepository.getById(request.getId());

	        if (website == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.WEBSITE_NOT_FOUND);
	            return response;
	        }

	        website.setDomainId(request.getDomainId());
	        website.setWebsiteUrl(request.getWebsiteUrl());
	        website.setWebsitePlatfrom(request.getWebsitePlatfrom());
	        website.setUsername(request.getUsername());
	        website.setPassword(request.getPassword());
	        website.setCreatedAt(request.getCreatedAt());

	        Website updatedWebsite = websiteRepository.save(website);

	        WebsiteDto dto = websiteMapper.toWebsiteDto(updatedWebsite);

	        response.setStatus(HttpStatus.OK);
	        response.setResponseMessage(Constants.WEBSITE_UPDATED_SUCCESSFULLY);
	        response.setData(dto);

	        return response;

	    } catch (Exception e) {
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        response.setResponseMessage("Error: " + e.getMessage());
	        return response;
	    }
	}
	@Override
	public Message<WebsiteDto> getwebsitesBydomain(String domain) {

	    Message<WebsiteDto> response = new Message<>();

	    try {

	        Domain_Details domainDetails = domain_DetailsRepository.getByDomain(domain);

	        if (domainDetails == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.DOMAIN_NOT_FOUND);
	            return response;
	        }

	        Website website = websiteRepository.getByDomainId(domainDetails.getId());

	        if (website == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.WEBSITE_NOT_FOUND);
	            return response;
	        }

	        WebsiteDto dto = websiteMapper.toWebsiteDto(website);

	        response.setStatus(HttpStatus.OK);
	        response.setResponseMessage(Constants.WEBSITE_FETCH_SUCCESSFULLY);
	        response.setData(dto);

	        return response;

	    } catch (Exception e) {

	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        response.setResponseMessage("Error: " + e.getMessage());

	        return response;
	    }
	}

	@Override
	public Message<WebsiteDto> getWebsiteById(int id) {
	    Message<WebsiteDto> response = new Message<>();

	    try {
	        Website website = websiteRepository.getById(id);

	        if (website == null) {
	            response.setStatus(HttpStatus.NOT_FOUND);
	            response.setResponseMessage(Constants.WEBSITE_NOT_FOUND);
	            return response;
	        }

	        WebsiteDto dto = websiteMapper.toWebsiteDto(website);

	        response.setStatus(HttpStatus.OK);
	        response.setResponseMessage(Constants.WEBSITE_FETCH_SUCCESSFULLY);
	        response.setData(dto);
	        return response;

	    } catch (Exception e) {
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        response.setResponseMessage("Error: " + e.getMessage());
	        return response;
	    }
	}

	@Override
	public Message<WebsiteDto> deleteWebsite(int id) {
		Message<WebsiteDto> response = new Message<>();
		try {
			Optional<Website> website = websiteRepository.findById(id);
			
			if (!website.isPresent()) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.WEBSITE_NOT_FOUND);
				return response;
			}
			websiteRepository.deleteById(id);
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.WEBSITE_DELETED_SUCCESSFULLY);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
		
	}

}
