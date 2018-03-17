package com.moh.uemoagovies.services;

import java.util.List;

import com.moh.uemoagovies.domain.GoviesIssue;

public interface GoviesIssueService extends CRUDService<GoviesIssue>{

	public List<GoviesIssue> getGoviesIssueByCodeIsin(String codeIsin);
	public GoviesIssue getGoviesIssueByIssuer(String issuer);
	public GoviesIssue getGoviesIssueByGoviesType(String goviesType);
	public Iterable<GoviesIssue> getGoviesIssueList();
}
