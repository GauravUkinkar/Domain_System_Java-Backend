package com.MSBJ.Mapper;

import com.MSBJ.Dto.Domain_DetailsDto;
import com.MSBJ.Model.Domain_Details;

public interface Domain_DetailsMapper {
	
	public Domain_DetailsDto toDomain_DetailsDto(Domain_Details domain_Details);
	public Domain_Details toDomain_Details(Domain_DetailsDto domain_DetailsDto);

}
