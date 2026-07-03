package com.MSBJ.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
@ComponentScan("com.MSBJ")
@EntityScan("com.MSBJ.demo")
@EnableJpaRepositories("com.MSBJ.Repository")
public class MailSystemBackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSystemBackendJavaApplication.class, args);
	}

}
