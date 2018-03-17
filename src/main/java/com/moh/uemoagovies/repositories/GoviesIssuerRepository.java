package com.moh.uemoagovies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moh.uemoagovies.domain.GoviesIssuer;

public interface GoviesIssuerRepository extends CrudRepository<GoviesIssuer, Long> {

	GoviesIssuer findByShortName(String shortName);
	GoviesIssuer findByFullName(String fullName);
}
