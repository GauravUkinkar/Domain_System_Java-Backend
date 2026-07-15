package com.MSBJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSBJ.Model.Domain_Details;

@Repository

public interface Domain_DetailsRepository extends JpaRepository<Domain_Details, Integer> {

	Domain_Details getByDomain(String domain);

}
