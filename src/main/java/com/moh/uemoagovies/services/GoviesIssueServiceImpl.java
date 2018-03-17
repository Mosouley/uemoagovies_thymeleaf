package com.moh.uemoagovies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moh.uemoagovies.domain.GoviesIssue;
import com.moh.uemoagovies.repositories.GoviesIssueRepository;

@Service
public class GoviesIssueServiceImpl implements GoviesIssueService {

	@Autowired
	GoviesIssueRepository goviesIssueRepository;
	
	@Override
	public List<GoviesIssue> getGoviesIssueByCodeIsin(String codeIsin) {
		
		return goviesIssueRepository.findByCodeIsin(codeIsin);
	}

	@Override
	public GoviesIssue getGoviesIssueByIssuer(String issuer) {
		
		return goviesIssueRepository.findByIssuer(issuer);
	}

	@Override
	public GoviesIssue getGoviesIssueByGoviesType(String goviesType) {
		
		return goviesIssueRepository.findByGoviesType(goviesType);
	}

	@Override
	public Iterable<GoviesIssue> getGoviesIssueList() {
		
		return goviesIssueRepository.findAll();
	}

	@Override
	public Iterable<GoviesIssue> listAll() {
		return goviesIssueRepository.findAll();
	}

	@Override
	public GoviesIssue getById(Long id) {
		return goviesIssueRepository.findOne(id);
	}

	@Override
	public GoviesIssue saveOrUpdate(GoviesIssue domainObject) {
		return goviesIssueRepository.save(domainObject);
	}

	@Override
	public void delete(Long id) {
		
		goviesIssueRepository.delete(id);
		
	}

}
