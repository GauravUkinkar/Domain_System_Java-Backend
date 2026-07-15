package com.MSBJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSBJ.Model.Website;

@Repository

public interface WebsiteRepository extends JpaRepository<Website, Integer> {



	Website getByDomainId(int id);

}
