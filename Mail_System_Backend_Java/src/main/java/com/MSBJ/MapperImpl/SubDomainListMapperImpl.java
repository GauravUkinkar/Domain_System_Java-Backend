package com.MSBJ.MapperImpl;

import org.springframework.stereotype.Component;

import com.MSBJ.Dto.SubDomainListDto;
import com.MSBJ.Mapper.SubDomainListMapper;
import com.MSBJ.Model.Subdomain_List;

@Component
public class SubDomainListMapperImpl implements SubDomainListMapper{

	@Override
	public Subdomain_List tosubSubdomain_List(SubDomainListDto dto) {
		Subdomain_List subdomain_List = new Subdomain_List();
		subdomain_List.setId(dto.getId());
		subdomain_List.setDomainId(dto.getDomainId());
		subdomain_List.setSubdomain(dto.getSubdomain());
		subdomain_List.setDescription(dto.getDescription());
		subdomain_List.setCreatedAt(dto.getCreatedAt());
		return subdomain_List;
				
	}

	@Override
	public SubDomainListDto tosubDomainListDto(Subdomain_List subdomain_List) {
		SubDomainListDto dto = new SubDomainListDto();
		dto.setId(subdomain_List.getId());
		dto.setDomainId(subdomain_List.getDomainId());
		dto.setSubdomain(subdomain_List.getSubdomain());
		dto.setDescription(subdomain_List.getDescription());
		dto.setCreatedAt(subdomain_List.getCreatedAt());
		return dto;
	}

}
