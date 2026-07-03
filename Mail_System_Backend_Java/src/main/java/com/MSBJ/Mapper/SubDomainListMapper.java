package com.MSBJ.Mapper;

import com.MSBJ.Dto.SubDomainListDto;
import com.MSBJ.Model.Subdomain_List;

public interface SubDomainListMapper {
	
	public Subdomain_List tosubSubdomain_List(SubDomainListDto dto);
	public SubDomainListDto tosubDomainListDto(Subdomain_List subdomain_List);

}
