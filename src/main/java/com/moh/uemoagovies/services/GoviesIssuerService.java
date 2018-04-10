package com.moh.uemoagovies.services;



import com.moh.uemoagovies.domain.GoviesIssuer;

public interface GoviesIssuerService extends CRUDService<GoviesIssuer>{

	public GoviesIssuer getIssuerByShortName(String shortName); 
	
	public GoviesIssuer getIssuerByFullName(String fullName);
}
