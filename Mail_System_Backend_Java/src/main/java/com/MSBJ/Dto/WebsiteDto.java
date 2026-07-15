package com.MSBJ.Dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain=true)

public class WebsiteDto {
	private int id;
	private int domainId;
	private String websiteUrl;
	private String websitePlatfrom;
	private String username;
	private String password;
	private String createdAt;

}
