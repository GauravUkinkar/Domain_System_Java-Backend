package com.MSBJService;

import java.util.List;

import com.MSBJ.Dto.Domain_DetailsDto;
import com.MSBJ.Dto.EmailDto;
import com.MSBJ.Dto.Message;

public interface Domain_DetailsService {

 public Message<Domain_DetailsDto> addDomain(Domain_DetailsDto request);
 public Message<Domain_DetailsDto> getDomainById(int id);
 public Message<Domain_DetailsDto> domainEdit(Domain_DetailsDto request);
 public Message<Domain_DetailsDto> deleteDomain(int id);
 public List<Message<Domain_DetailsDto>> getAllDomain();
}