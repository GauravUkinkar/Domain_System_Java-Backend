package com.MSBJ.Dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain=true)

public class EmailDto {
	private int id;
	private String email;
	private int domainId;
	private String username;
	private String password;
	private String platform;
	private String status;
	private String createdAt;
	private String primaryTag;

}
