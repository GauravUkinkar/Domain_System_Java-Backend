package com.MSBJ.Dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain=true)

public class Domain_DetailsDto {
	private int id;
	private String domain;
	private String purchasePlatform;
	private String purchaseDate;
	private String expiryDate;
	private String expiryStatus;
	private String platformUrl;
	private String username;
	private String password;
	private String createdAt;

}


