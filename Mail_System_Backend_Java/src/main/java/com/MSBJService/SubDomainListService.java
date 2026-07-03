package com.MSBJService;

import com.MSBJ.Dto.Message;
import com.MSBJ.Dto.SubDomainListDto;

public interface SubDomainListService {
	public Message<SubDomainListDto> addSubdomain(SubDomainListDto request);
    public Message<SubDomainListDto> getsubdomainBYId(int id);
    public Message<SubDomainListDto> editSubdomain(SubDomainListDto request);
    public Message<SubDomainListDto> deleteSubdomain(int id);

}
