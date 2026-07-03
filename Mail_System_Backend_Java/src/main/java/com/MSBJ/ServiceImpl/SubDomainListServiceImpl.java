package com.MSBJ.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.SubDomainListDto;
import com.MSBJ.Mapper.SubDomainListMapper;
import com.MSBJ.Model.Subdomain_List;
import com.MSBJ.Repository.SubDomainListRepository;
import com.MSBJ.Util.Constants;
import com.MSBJService.SubDomainListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SubDomainListServiceImpl implements SubDomainListService {
	
	private final SubDomainListMapper subDomainMapper;
	private final SubDomainListRepository subDomainListRepository;

	@Override
	public Message<SubDomainListDto> addSubdomain(SubDomainListDto request) {
        Message<SubDomainListDto> response = new Message<>();
        
        try {
			if (request == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setResponseMessage(Constants.INVALID_INPUT_DATA);
				return response;
			}
			
			Subdomain_List subdomain_List = new Subdomain_List();
			subdomain_List = subDomainMapper.tosubSubdomain_List(request);
			subDomainListRepository.save(subdomain_List);
			SubDomainListDto dto = subDomainMapper.tosubDomainListDto(subdomain_List);
			
			response.setStatus(HttpStatus.OK);
			response.setResponseMessage(Constants.SUBDOMAIN_ADDED_SUCESSFULLY);
			response.setData(dto);
			return response;
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponseMessage("Error:" +e.getMessage());
			return response;
		}
 	}

	@Override
	public Message<SubDomainListDto> getsubdomainBYId(int id) {
		Message<SubDomainListDto> response = new Message<>();
		
		try {
			Subdomain_List subDomainList = subDomainListRepository.getById(id);
			
			if (subDomainList == null) {
				response.setStatus(HttpStatus.NOT_FOUND);
				response.setResponseMessage(Constants.SUBDOMAIN_NOT_FOUND);
				return response;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Message<SubDomainListDto> editSubdomain(SubDomainListDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message<SubDomainListDto> deleteSubdomain(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
