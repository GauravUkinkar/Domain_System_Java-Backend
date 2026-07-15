package com.MSBJ.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Entity
@Accessors(chain=true)
public class Website {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int domainId;
	private String websiteUrl;
	private String websitePlatfrom;
	private String username;
	private String password;
	private String createdAt;


}
