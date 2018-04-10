package com.moh.uemoagovies.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moh.uemoagovies.domain.GoviesIssuer;
import com.moh.uemoagovies.repositories.GoviesIssuerRepository;

@Service
public class GoviesIssuerServiceImpl implements GoviesIssuerService {

	@Autowired
	GoviesIssuerRepository goviesIssuerRepository;

	@Override
	public GoviesIssuer getIssuerByShortName(String shortName) {
		return goviesIssuerRepository.findByShortName(shortName);
	}

	@Override
	public  GoviesIssuer getIssuerByFullName(String fullName) {
		return goviesIssuerRepository.findByFullName(fullName);
	}

	@Override
	public Iterable<GoviesIssuer> listAll() {
		return goviesIssuerRepository.findAll();
	}

	@Override
	public GoviesIssuer getById(Long id) {
		return goviesIssuerRepository.findOne(id);
	}

	@Override
	public GoviesIssuer saveOrUpdate(GoviesIssuer domainObject) {

		return goviesIssuerRepository.save(domainObject);
	}

	@Override
	public void delete(Long id) {
		goviesIssuerRepository.delete(id);
	}
}
