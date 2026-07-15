package com.MSBJ.MapperImpl;

import org.springframework.stereotype.Component;

import com.MSBJ.Dto.WebsiteDto;
import com.MSBJ.Mapper.WebsiteMapper;
import com.MSBJ.Model.Website;

@Component

public class WebsiteMapperImpl implements WebsiteMapper {

	@Override
	public Website toWebsite(WebsiteDto websiteDto) {
		return new Website()
				.setId(websiteDto.getId())
				.setUsername(websiteDto.getUsername())
				.setPassword(websiteDto.getPassword())
				.setCreatedAt(websiteDto.getCreatedAt())
				.setDomainId(websiteDto.getDomainId())
				.setWebsitePlatfrom(websiteDto.getWebsitePlatfrom())
				.setWebsiteUrl(websiteDto.getWebsiteUrl());
		
	}

	@Override
	public WebsiteDto toWebsiteDto(Website website) {
		return new WebsiteDto()
				.setId(website.getId())
				.setUsername(website.getUsername())
				.setPassword(website.getPassword())
				.setCreatedAt(website.getCreatedAt())
				.setDomainId(website.getDomainId())
				.setWebsitePlatfrom(website.getWebsitePlatfrom())
				.setWebsiteUrl(website.getWebsiteUrl());
		
	}

}
