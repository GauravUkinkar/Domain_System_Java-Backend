package com.MSBJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSBJ.Model.Subdomain_List;

@Repository
public interface SubDomainListRepository extends JpaRepository<Subdomain_List, Integer>{

}
