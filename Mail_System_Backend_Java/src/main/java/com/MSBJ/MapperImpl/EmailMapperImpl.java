package com.MSBJ.MapperImpl;

import org.springframework.stereotype.Component;

import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Mapper.EmailMapper;
import com.MSBJ.Model.Email;

@Component

public class EmailMapperImpl implements EmailMapper {

	@Override
	public EmailDto toEmailDto(Email email) {
		return new EmailDto()
				.setId(email.getId())
				.setCreatedAt(email.getCreatedAt())
				.setDomainId(email.getDomainId())
				.setEmail(email.getEmail())
				.setPassword(email.getPassword())
				.setPlatform(email.getPlatform())
				.setPrimaryTag(email.getPrimaryTag())
				.setStatus(email.getStatus())
				.setUsername(email.getUsername());
		
	}

	@Override
	public Email toEmail(EmailDto emailDto) {
		return new Email()
				.setId(emailDto.getId())
				.setCreatedAt(emailDto.getCreatedAt())
				.setDomainId(emailDto.getDomainId())
				.setEmail(emailDto.getEmail())
				.setPassword(emailDto.getPassword())
				.setPlatform(emailDto.getPlatform())
				.setPrimaryTag(emailDto.getPrimaryTag())
				.setStatus(emailDto.getStatus())
				.setUsername(emailDto.getUsername());
		
	}

}
