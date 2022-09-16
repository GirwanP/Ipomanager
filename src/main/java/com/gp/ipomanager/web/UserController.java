package com.gp.ipomanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.repository.RoleRepository;
import com.gp.ipomanager.userservice.SecurityService;
import com.gp.ipomanager.userservice.UserService;
import com.gp.ipomanager.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
   
    @Autowired
    RoleRepository roleRepository;
    
   
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "candidateQualifications";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
     userForm.setActive(true);
        userService.saveCandidateUser(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {

//    	User curuser=securityService.getLoggedInUser();

//    	boolean isadmin=false,iscandidate=false;
//    	
//    	for(Role r:curuser.getRoles()) {
//    		if (r.getName().contains("admin")) {isadmin=true;}
//    		if (r.getName().contains("candidate")) {iscandidate=true;}
//    		
//    	}
    	

    	
       
        return "welcomeCandidate";
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
