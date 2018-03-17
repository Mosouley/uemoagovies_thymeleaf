package com.moh.uemoagovies.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moh.uemoagovies.domain.GoviesIssue;



public interface GoviesIssueRepository extends CrudRepository<GoviesIssue, Long> {

	List<GoviesIssue> findByCodeIsin(String codeIsin);
	GoviesIssue findByIssuer(String issuer);
	GoviesIssue findByGoviesType(String goviesType);

}
