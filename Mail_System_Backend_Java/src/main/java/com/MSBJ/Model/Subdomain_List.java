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
public class Subdomain_List {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int domainId;
	private String subdomain;
	private String description;
	private String createdAt;

}
