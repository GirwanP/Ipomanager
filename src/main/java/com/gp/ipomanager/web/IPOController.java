package com.gp.ipomanager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gp.ipomanager.dto.ApplicantDTO;
import com.gp.ipomanager.dto.DmatAccountDTO;
import com.gp.ipomanager.dto.IPOOpeningDTO;
import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.services.ApplicantsServices;
import com.gp.ipomanager.services.IPOService;

@Controller
public class IPOController {

   @Autowired
   IPOService iposervice;
   
   @Autowired
   ApplicantsServices applicantservice;

	
   @Deprecated// not implemented
    @GetMapping("/ipodetail")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        
        return "ipodetail";
    }
 
    @GetMapping("/addnewIPOissue")
    public String addnewIPOopening(Model model) {
        model.addAttribute("ipo", new IPOOpeningDTO());

        return "newIpo";
    }

    @PostMapping("/addnewIPOissue")
    public String addnewIPOopening(@ModelAttribute("ipo") IPOOpeningDTO newIPO, BindingResult bindingResult) {

    	iposervice.registerNewIPOOPening(newIPO);
        
        return "redirect:/allipos";
    }

    @GetMapping("/allipos")
    public String getallIPOS(Model model) {
    	
    	List<IPOOpeningDTO> ipos=iposervice.getActiveIPOs();
    	
    	model.addAttribute("ipos", ipos);
    	
        return "ipoList";
    }

    @GetMapping("/markipoinactive")
    public String getallIPOS(Model model,@RequestParam(name="ipoid")Long ipoid) {
    	
//    	boolean ipos=
    	iposervice.markIPOInactive(ipoid);
    	
    	
        return "redirect:/allipos";
    }
    
  
    
    // go to opo application from here
    @GetMapping("/getapplicant")
    public String getapplicant(Model model,@RequestParam(name="applicantId") Long applicantId
//    		,@ModelAttribute(name = "dmat")DmatAccountDTO dmat
//    		,BindingResult br
    		) {
        
    	ApplicantDTO applicant= applicantservice.getApplicant(applicantId);
    	Optional<DmatAccountDTO> dmat=applicantservice.getDematDetail1(applicantId);
    	
    	if(dmat.isPresent()) {
    		model.addAttribute("dmat", dmat.get());
    	}
    	
    	model.addAttribute("applicant", applicant);
        return "applicantdetail";
    }
    
    @GetMapping("/disableapplicant")
    public String disableapplicant(Model model,@RequestParam(name="applicantId") Long applicantId
//    		,@ModelAttribute(name = "dmat")DmatAccountDTO dmat
//    		,BindingResult br
    		) {
        
    	applicantservice.inactivateApplicant(applicantId);
    	
        return "redirect:/getapplicants";
    }
    
    /**
     * Return the list of applicants 
     * Option to add new applicant
     * 
     * @param model
     * @return
     */
    @GetMapping("/getapplicants")
    public String getapplicants(Model model) {
        
    	List<ApplicantDTO> applicants=applicantservice.getActiveApplicants();
    	ApplicantDTO applicant=new ApplicantDTO();
    	
    	model.addAttribute("applicants", applicants);
    	model.addAttribute("applicant", applicant);


        return "applicantlist";
    }
    
    
    // applicant
    /*
     * feature avalable in list page
     */
    @Deprecated
    @GetMapping("/addnewapplicant")
    public String addapplicant(Model model) {
        model.addAttribute("applicant", new User());
        return "registerapplicant";
    }

    
    @PostMapping("/addnewapplicant")
    public String addapplicant(@ModelAttribute(name = "applicant")ApplicantDTO applicant) {

    	applicantservice.addNewApplicant(applicant);
    	
        return "redirect:/getapplicants";
    }
    
   
    @PostMapping("/adddmat")
    public String demat(@RequestParam(name = "applicantId")Long applicantId
    		,@ModelAttribute(name = "dmat")DmatAccountDTO dmat
    		,BindingResult br
    		) {

    	applicantservice.addDematInfo(applicantId, dmat);
    	
        return "redirect:/getapplicant?applicantId="+applicantId;
    }

    
    @GetMapping("/editdmat")
    public String editdmatg(@RequestParam(name = "applicantId")Long applicantId
//    		,@ModelAttribute(name = "dmat")DmatAccountDTO dmat
//    		,BindingResult br
    		,Model model
    		) {
    	DmatAccountDTO dmat=applicantservice.getDematDetail(applicantId);
    	
    	model.addAttribute("dmat", dmat);
    	model.addAttribute("applicantId", applicantId);
    	
        return "editDmat";
    }
    @PostMapping("/editdmat")
    public String editdmat(
//    		@RequestParam(name = "applicantId")Long applicantId
//    		,
    		@ModelAttribute(name = "dmat")DmatAccountDTO dmat
    		,BindingResult br
    		) {

    	applicantservice.editDematInfo(dmat);
    	
        return "redirect:/getapplicant?applicantId="+dmat.getApplicantId();
    }
    
    
    
    /**
     * to be implemented later
     */
    
    
    @GetMapping("/adddmat")
    public String dematp() {

        return "";
    }
    
    @PostMapping("/addbankaccount")
    public String addbank() {

        return "";
    }
    
    @PostMapping("/addbankaccountForpay")
    public String addbankpayment() {

        return "";
    }
    
    
    @PostMapping("/applyForIpo")
    public String apply() {

        return "";
    }
    
    
}
