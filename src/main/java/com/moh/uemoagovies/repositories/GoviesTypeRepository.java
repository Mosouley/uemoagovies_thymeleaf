package com.moh.uemoagovies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moh.uemoagovies.domain.GoviesType;

public interface GoviesTypeRepository extends CrudRepository<GoviesType, Long> {

	GoviesType findByshortName(String shortName);
}
