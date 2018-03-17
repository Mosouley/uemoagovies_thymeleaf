package com.moh.uemoagovies.services;



import com.moh.uemoagovies.domain.GoviesIssuer;

public interface GoviesIssuerService {

	public Iterable<GoviesIssuer> listAllGoviesIssuers();
	
	public GoviesIssuer getGoviesIssuerById(Long id);
	
	public GoviesIssuer getIssuerByShortName(String shortName); 
	
	public GoviesIssuer getIssuerByFullName(String fullName);
}
