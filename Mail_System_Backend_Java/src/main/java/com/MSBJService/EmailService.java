package com.MSBJService;

import java.util.List;

import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Dto.Message;
import com.MSBJ.Model.Email;

public interface EmailService { 
	public Message<EmailDto> addEmail(EmailDto request);
	public Message<EmailDto> emailEdit(EmailDto request);
	public Message<EmailDto> getEmailByid(int id);
	public Message<EmailDto> getEmailByDomain(String domain);
	public Message<EmailDto> deletEmail(int id);
	public Message<EmailDto> addprimary(String email);
	public List<Message<EmailDto>> getAllEmails();

}
