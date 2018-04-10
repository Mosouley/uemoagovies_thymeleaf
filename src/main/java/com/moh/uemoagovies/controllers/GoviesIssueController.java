package com.moh.uemoagovies.controllers;

import java.io.File;


import javax.validation.Valid;

import com.moh.uemoagovies.helpers.GoviesRepayMode;
import com.moh.uemoagovies.repositories.GoviesTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.moh.uemoagovies.domain.GoviesIssue;
import com.moh.uemoagovies.domain.GoviesType;
import com.moh.uemoagovies.domain.User;
import com.moh.uemoagovies.services.GoviesIssueService;
import com.moh.uemoagovies.services.GoviesIssuerService;
import com.moh.uemoagovies.services.UserService;


//import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping(path = "/govies")
public class GoviesIssueController {

	@Autowired
	GoviesIssueService goviesIssueService ;
	@Autowired
	GoviesIssuerService goviesIssuerService ;
	@Autowired
	GoviesTypeRepository goviesTypeRepository;
	
	@Autowired
	private UserService userService;
	
	@Value("${dir.images}")
	private String imageDir;


	
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
//		return "login";
	}
    @RequestMapping(value={"/login"}, method = RequestMethod.POST)
  	public String connect(){
  		
  		return "redirect:listIssue";
  	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}


	@RequestMapping(value= "/listIssue", method = RequestMethod.GET)
	//@ApiOperation(value = "Get the list of all the govies issued in the market", notes = "Get the list of all the govies issued in the market")
	public String getAllGoviesIssue(Model model) {
		Iterable<GoviesIssue> listeGov=goviesIssueService.getGoviesIssueList();
		model.addAttribute("issueList",listeGov );

		return "goviesissue";
	}

	@RequestMapping(value= "/listGoviesType", method = RequestMethod.GET)
	//@ApiOperation(value = "Get the list of all the govies issued in the market", notes = "Get the list of all the govies issued in the market")
	public String getAllGoviestype(Model model) {
		Iterable<GoviesType> listeType=goviesTypeRepository.findAll();
		model.addAttribute("typeList",listeType );

		return "goviesType";
	}
	@RequestMapping(value="/formIssuance",method=RequestMethod.GET)
	public String formGovies(Model model) {

		model.addAttribute("issuance", new GoviesIssue());
		model.addAttribute("issuersList",goviesIssuerService.listAll() );

		model.addAttribute("typeList",goviesTypeRepository.findAll() );
		return "formIssuance";
	}
	
	@RequestMapping(value="/SaveGovies",method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("issuance") GoviesIssue issue,
			BindingResult bindingResult,
			@RequestParam(name="minutes")MultipartFile file, Model model) throws Exception {
		
		
		if (bindingResult.hasErrors()) {
			return "formIssuance";
		}

		if(!file.isEmpty()) {issue.setMinutesIssuance(file.getOriginalFilename());}
		goviesIssueService.saveOrUpdate(issue);
		if(!file.isEmpty()) {
			issue.setMinutesIssuance(file.getOriginalFilename());
//			file.transferTo(new File(imageDir+file.getOriginalFilename()));
			file.transferTo(new File(imageDir+issue.getId()));
		}
		
		return "redirect:listIssue";
	}

	@RequestMapping(value="/formGoviesType",method=RequestMethod.GET)
	public String formGoviesType(Model model) {

		model.addAttribute("goviesType", new GoviesType());
		model.addAttribute("typeList",goviesTypeRepository.findAll() );
		return "formGoviesType";
	}

	@RequestMapping(value="/SaveGoviesType",method=RequestMethod.POST)
	public String saveGoviesType(@Valid @ModelAttribute("goviesType") GoviesType type,
					   BindingResult bindingResult,
					    Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "formGoviesType";
		}
		model.addAttribute("typeList",goviesTypeRepository.findAll() );
		goviesTypeRepository.save(type);
		return "redirect:formGoviesType";
	}

}
