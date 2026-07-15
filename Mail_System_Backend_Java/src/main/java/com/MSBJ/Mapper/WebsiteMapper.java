package com.MSBJ.Mapper;

import com.MSBJ.Dto.WebsiteDto;
import com.MSBJ.Model.Website;

public interface WebsiteMapper {
	public Website toWebsite(WebsiteDto websiteDto);
	public WebsiteDto toWebsiteDto(Website website);

}
