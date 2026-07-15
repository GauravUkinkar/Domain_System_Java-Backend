package com.MSBJ.MapperImpl;

import org.springframework.stereotype.Component;

import com.MSBJ.Dto.Domain_DetailsDto;
import com.MSBJ.Mapper.Domain_DetailsMapper;
import com.MSBJ.Model.Domain_Details;

@Component

public class Domain_DetailsMapperImpl implements Domain_DetailsMapper {

	@Override
	public Domain_DetailsDto toDomain_DetailsDto(Domain_Details domain_Details) {
		return new Domain_DetailsDto()
				.setId(domain_Details.getId())
				.setDomain(domain_Details.getDomain())
				.setPurchaseDate(domain_Details.getPurchaseDate())
				.setPurchasePlatform(domain_Details.getPurchasePlatform())
				.setExpiryDate(domain_Details.getExpiryDate())
				.setExpiryStatus(domain_Details.getExpiryStatus())
				.setPlatformUrl(domain_Details.getPlatformUrl())
				.setUsername(domain_Details.getUsername())
				.setPassword(domain_Details.getPassword())
				.setCreatedAt(domain_Details.getCreatedAt());
		
	}

	@Override
	public Domain_Details toDomain_Details(Domain_DetailsDto domain_DetailsDto) {
		return new Domain_Details()
				.setUsername(domain_DetailsDto.getUsername())
				.setPurchasePlatform(domain_DetailsDto.getPurchasePlatform())
				.setPurchaseDate(domain_DetailsDto.getPurchaseDate())
				.setPlatformUrl(domain_DetailsDto.getPlatformUrl())
				.setPassword(domain_DetailsDto.getPassword())
				.setExpiryStatus(domain_DetailsDto.getExpiryStatus())
				.setExpiryDate(domain_DetailsDto.getExpiryDate())
				.setCreatedAt(domain_DetailsDto.getCreatedAt())
				.setDomain(domain_DetailsDto.getDomain())
				.setId(domain_DetailsDto.getId());
		
	}

}
