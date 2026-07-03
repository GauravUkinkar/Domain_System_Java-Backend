package com.MSBJ.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data 
@ToString
@Entity
public class Domain_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Domain;
	private String purchasePlatform;
	private String purchaseDate;
	private String expiryDate;
	private String expiryStatus;
	private String platformUrl;
	private String username;
	private String password;
	private String createdAt;

}
