package com.MSBJService;

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.WebsiteDto;

public interface WebsiteService {
	public Message<WebsiteDto> addWebsite(WebsiteDto request);
	public Message<WebsiteDto> editWebsite(WebsiteDto request);
	public Message<WebsiteDto> getwebsitesBydomain(String domain);
	public Message<WebsiteDto> getWebsiteById(int id);
	public Message<WebsiteDto> deleteWebsite(int id);
	

}
