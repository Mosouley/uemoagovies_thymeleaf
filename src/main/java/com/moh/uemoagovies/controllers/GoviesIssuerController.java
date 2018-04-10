package com.moh.uemoagovies.controllers;

import com.moh.uemoagovies.domain.GoviesIssue;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.moh.uemoagovies.domain.GoviesIssuer;
import com.moh.uemoagovies.services.GoviesIssuerService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;


@Controller
@RequestMapping(path = "/issuers")
public class GoviesIssuerController {
	
	@Autowired
	private GoviesIssuerService goviesIssuerService;
	@Value("${dir.images}")
	private String imageDir;


	@GetMapping(path = "/shortName}")
	public @ResponseBody GoviesIssuer getIssuerByShortName(@PathVariable String shortName) {
		return goviesIssuerService.getIssuerByShortName(shortName);
	}
	
	@GetMapping(path = "/listIssuers")
	public String getAllgoviesIssuers(Model model) {
		model.addAttribute("issuerList",goviesIssuerService.listAll());

		return "listIssuers";
	}

	@RequestMapping(value="/formIssuer",method=RequestMethod.GET)
	public String formGovies(Model model) {

		model.addAttribute("issuer", new GoviesIssuer());
		model.addAttribute("issuerList",goviesIssuerService.listAll());
		return "formIssuer";
	}
	@RequestMapping(value="/SaveIssuer",method= RequestMethod.POST)
	public String save(@Valid @ModelAttribute("issuer") GoviesIssuer issuer,
					   BindingResult bindingResult,
					   @RequestParam(name="flag")MultipartFile file, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "listIssuers";
		}

		if(!file.isEmpty()) {issuer.setFlagUrl(file.getOriginalFilename());}
		goviesIssuerService.saveOrUpdate(issuer);
		if(!file.isEmpty()) {
			issuer.setFlagUrl(file.getOriginalFilename());
			file.transferTo(new File(imageDir+"obl"+issuer.getId()));
		}

		return "redirect:formIssuer";
	}
	@RequestMapping(value="/supprimerIssuer",method=RequestMethod.GET)
	public String deleteIssuer(Long id) {
		goviesIssuerService.delete(id);
		return "formIssuer";
	}

	@RequestMapping(value="/editIssuer")
	public String edit(Long id, Model model) {
		GoviesIssuer issuer=goviesIssuerService.getById(id);
		model.addAttribute("issuer", issuer);
//		goviesIssuerService.saveOrUpdate(issuer);

		return "editIssuer";
	}

	@RequestMapping(value="/updateIssuer",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("issuer") GoviesIssuer theissuer,
						 BindingResult bindingResult,
						 @RequestParam(name="flag")MultipartFile file) throws Exception {

		if(theissuer!=null) {
			if (bindingResult.hasErrors()) {
				return "redirect:editIssuer";
			}
			if (!file.isEmpty()) {
				theissuer.setFlagUrl(file.getOriginalFilename());
			}
		GoviesIssuer goviesIssuer=goviesIssuerService.getById(theissuer.getId());

			goviesIssuerService.saveOrUpdate(goviesIssuer);

			if (!file.isEmpty()) {
				goviesIssuer.setFlagUrl(file.getOriginalFilename());
				file.transferTo(new File(imageDir + "obl" + goviesIssuer.getId()));
			}
		}
		return "redirect:listIssuers";
	}

	@RequestMapping(value="/getFlag",method=RequestMethod.GET,produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getFlag(Long id) throws Exception {
		File f=new File(imageDir+"obl"+id);
		if (!f.exists()){return  null;}
		return IOUtils.toByteArray(new FileInputStream(f));

	}
}
