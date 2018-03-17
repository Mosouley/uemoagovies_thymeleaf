package com.moh.uemoagovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.moh.uemoagovies.domain.GoviesIssuer;
import com.moh.uemoagovies.services.GoviesIssuerService;



@RestController
@RequestMapping(path = "/issuers")
public class GoviesIssuerController {
	
	@Autowired
	private GoviesIssuerService goviesIssuerService;
	
	@GetMapping(path = "/{shortName}")
	public @ResponseBody GoviesIssuer getIssuerByShortName(@PathVariable String shortName) {
		return goviesIssuerService.getIssuerByShortName(shortName);
	}
	
	@GetMapping(path = "/{fullName}")
	public @ResponseBody GoviesIssuer getIssuerByfullName(@PathVariable String fullName) {
		return goviesIssuerService.getIssuerByShortName(fullName);
	}
	
	@GetMapping(path = "/list")
	public Iterable<GoviesIssuer> getAllgoviesIssuers() {
		return goviesIssuerService.listAllGoviesIssuers();
	}
}
