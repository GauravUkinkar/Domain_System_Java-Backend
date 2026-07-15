package com.MSBJ.Mapper;

import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Model.Email;

public interface EmailMapper {
	
	
	public Email toEmail(EmailDto emailDto);
	public EmailDto toEmailDto(Email email);

}
