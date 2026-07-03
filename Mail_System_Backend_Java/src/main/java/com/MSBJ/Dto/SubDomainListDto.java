package com.MSBJ.Dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class SubDomainListDto {
	private int id;
	private int domainId;
	private String subdomain;
	private String description;
	private String createdAt;
}
