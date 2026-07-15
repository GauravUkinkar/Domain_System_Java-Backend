package com.MSBJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MSBJ.Model.Email;

@Repository

public interface EmailRepository extends JpaRepository<Email, Integer> {
	Email getByDomainId(int id);

}
