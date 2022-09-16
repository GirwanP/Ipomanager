package com.gp.ipomanager.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.userservice.SecurityService;
import com.gp.ipomanager.userservice.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	
	@GetMapping("/qualifications")
	public String cqualification(Model model) {
		User curuser = securityService.getLoggedInUser();

		if (userService.isCurrentUserAdmin(curuser)) {
//			List<QualificationEntry> qlist = qualificationsSercice.getAllQualifications();
//
//			List<QualificationType> qtlist = qualificationTypeRepository.findAll();
//
//			model.addAttribute("username", curuser.getUsername());
//			model.addAttribute("qlist", qlist);
//			model.addAttribute("qtlist", qtlist);

			return "admin/qualification";
		} else {
			return "redirect:/";
		}

		// curuser.get
		// Candidate c=candidateSercice.getCandidateForuser(curuser);

	}

	

	

	

	
	

	

}
