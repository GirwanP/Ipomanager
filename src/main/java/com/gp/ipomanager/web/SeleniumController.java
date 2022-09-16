package com.gp.ipomanager.web;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gp.ipomanager.dto.ApplicantDTO;
import com.gp.ipomanager.dto.ApplicationBatch;
import com.gp.ipomanager.dto.ApplicationQuantity;
import com.gp.ipomanager.dto.DmatAccountDTO;
import com.gp.ipomanager.dto.IPOOpeningDTO;
import com.gp.ipomanager.dto.InteractiveCommandParamsDto;
import com.gp.ipomanager.entities.ActionParam;
import com.gp.ipomanager.entities.OperationTemplate;
import com.gp.ipomanager.enums.BrowserType;
import com.gp.ipomanager.enums.ByType;
import com.gp.ipomanager.enums.PathParamType;
import com.gp.ipomanager.enums.WebElementActions;
import com.gp.ipomanager.services.ApplicantsServices;
import com.gp.ipomanager.services.Automationservice;
import com.gp.ipomanager.services.IPOService;
import com.gp.ipomanager.services.OperationTemplateService;

@Controller
public class SeleniumController {


	@Autowired
	Automationservice autopilot;

	@Autowired
	OperationTemplateService otservice;

	@Deprecated
	@GetMapping("/addoperationtemplate")
	public String registration(Model model) {


		model.addAttribute("detailForm", new OperationTemplate());

		return "/selenium/";
	}

	@PostMapping("/addoperationtemplate")
	public String addnewIPOopening(@ModelAttribute("template") OperationTemplate template, BindingResult bindingResult) {
			otservice.addNewOperationTemplate(template);

		return "redirect:/allotemplates";
	}
	
	@GetMapping("/allotemplates")
    public String getallOS(Model model) {

		List<OperationTemplate> templates=otservice.getAllTemplates();
    	
		model.addAttribute("templates", templates);
		model.addAttribute("template", new OperationTemplate());
    	
        return "operationtemplatelist";
    }

	@GetMapping("/otdetail")
	public String registration(Model model,@RequestParam(name = "templateid") Long templateId) {

		OperationTemplate template = otservice.getOperationTemplate(templateId);
		
		List<ByType> byList=Arrays.asList(ByType.values());
		List<PathParamType> pathParamType=Arrays.asList(PathParamType.values());
		List<WebElementActions> actions=Arrays.asList(WebElementActions.values());
		
		model.addAttribute("template", template);
		model.addAttribute("tactions", template.getActions());
		
		model.addAttribute("byList", byList);
		model.addAttribute("pathParamType", pathParamType);
		model.addAttribute("actions", actions);
		
		model.addAttribute("actionparam", new ActionParam());
		

		return "otdetail";
	}

@Deprecated
	@GetMapping("/addactionparams")
	public String addActionParams(Model model,@RequestParam(name = "templateid") Long templateId) {

		OperationTemplate template = otservice.getOperationTemplate(templateId);

		List<ByType> byList=Arrays.asList(ByType.values());
		List<PathParamType> pathParamType=Arrays.asList(PathParamType.values());
		List<WebElementActions> actions=Arrays.asList(WebElementActions.values());

		model.addAttribute("template", template);
		model.addAttribute("byList", byList);
		model.addAttribute("pathParamType", pathParamType);
		model.addAttribute("actions", actions);
		model.addAttribute("actionparam", new ActionParam());

		return "/selenium/";
	}

	@PostMapping("/addactionparams")
	public String addActionParamsP(@ModelAttribute(name="actionparam")ActionParam param
			,@RequestParam(name = "templateid") Long templateId) {

//		boolean success = 
		otservice.addNewActionParam(templateId, param);

		return "redirect:/otdetail?templateid="+templateId;
	}


	@GetMapping("/editactionparams")
	public String editPost(Model model,@RequestParam(name = "paramId") Long paramId
			,@RequestParam(name = "templateid") Long templateId
			) {

		ActionParam actionparam= otservice.getActionParam(paramId);

		List<ByType> byList=Arrays.asList(ByType.values());
		List<PathParamType> pathParamType=Arrays.asList(PathParamType.values());
		List<WebElementActions> actions=Arrays.asList(WebElementActions.values());

		//    	model.addAttribute("template", template);
		model.addAttribute("byList", byList);
		model.addAttribute("pathParamType", pathParamType);
		model.addAttribute("actions", actions);
		model.addAttribute("actionparam", actionparam);
		model.addAttribute("templateid", templateId);

		return "selenium/editActionParam";
	}

	@PostMapping("/editactionparams")
	public String edit(@ModelAttribute(name="actionparam")ActionParam param
			,@RequestParam(name = "templateid") Long templateId
			) {
		otservice.editActionParam(param);

		return "redirect:/otdetail?templateid="+templateId;
	}


	public boolean initiateAutoPilotMeroshare(ApplicationBatch batch) throws InterruptedException {

		String url="https://meroshare.cdsc.com.np/";
		
		
		OperationTemplate template=otservice.getOperationTemplate(batch.getOperationTemplateId());
		
		IPOOpeningDTO ipo=ipoService.getIpo(batch.getIpoId());

		for(ApplicationQuantity a:batch.getQuantities()) {
			
			
			if(a.isApply()){
				Thread.sleep(3000);
				WebDriver driver=autopilot.getDriver(url, BrowserType.firefox);

				
				DmatAccountDTO dmat=applicantService.getDematDetail1(a.getApplicantId()).get();
				
				Map<String, String> driveMap=new HashMap<String, String>();
				
				if(batch.isUseDefaultQuantity()) {
					driveMap.put("kittas", batch.getDefaultQuantity().toString());
				}else {
					driveMap.put("kittas", a.getKittaToApply().toString());	
				}
				
				driveMap.put("company", ipo.getCompanyName());
				
				for(Field m:IPOOpeningDTO.class.getDeclaredFields()) {
					
					try {
						
						m.setAccessible(true);
						driveMap.put(m.getName(), m.get(ipo).toString());
						
					} catch (NullPointerException | IllegalArgumentException | IllegalAccessException e) {
						System.out.println(m.getName()+" : field has null value");
					}
					
					
				}
				
				// information from the dmat account
for(Field m:DmatAccountDTO.class.getDeclaredFields()) {
					
					try {
						
						m.setAccessible(true);
						driveMap.put(m.getName(), m.get(dmat).toString());
						
						m.setAccessible(false);
						
					} catch (NullPointerException | IllegalArgumentException | IllegalAccessException e) {
						System.out.println(m.getName()+" : field has null value");
					}
					
					
				}
				
				
				/*
				 * careful about order
				 * perform each step
				 */
				for(ActionParam ap:template.getActions()) {
					
					InteractiveCommandParamsDto parameters=new InteractiveCommandParamsDto();
					
					parameters.setActiontype(ap.getActiontype());
					parameters.setBytype(ap.getBytype());
					
					if(ap.getActiontype().equals(WebElementActions.sendKeys)) {
						parameters.setParam1(driveMap.get(ap.getIpParamName()));
					}
					
					String path=ap.getPathStringHead().toString();
					System.out.println(path);
					if(ap.getPathParamType().equals(PathParamType.sourceMap)) {
						path=path+Optional.ofNullable(driveMap.get(ap.getXpParamName())).get();
					}else if(ap.getPathParamType().equals(PathParamType.xParam)) {
						path=path+Optional.ofNullable(ap.getPathParam()).get();
					}
					if(ap.getPathStringTail()!=null) {
						path=path+ap.getPathStringTail();
					}
					
					parameters.setPathString(path);
					
					try {
//						WebElement elem=
								autopilot.executeInteractiveManual(parameters, driver);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.sleep(5000);
				}

				Thread.sleep(5000);

				driver.close();
				driver.quit();
			}
			
			
			
		}

		


		System.out.println("finishing");

		return false;
	}

	/*
	 * Ipo applications
	 */

	@Autowired
	IPOService ipoService;
	@Autowired
	ApplicantsServices applicantService;

	@GetMapping("/batchapplicationsconf")
	public String getbatchapplicationsconfiguration(Model model) {


		List<IPOOpeningDTO> activeipos=ipoService.getActiveIPOs();
		List<ApplicantDTO> applicants=applicantService.getActiveApplicants();
		List<OperationTemplate> templates=otservice.getAllTemplates();
		
		List<Boolean> tfl=Arrays.asList(true,false);

		model.addAttribute("tfl", tfl);
		model.addAttribute("templates", templates);
		model.addAttribute("activeipos", activeipos);
		model.addAttribute("applicants", applicants);
		model.addAttribute("batchForm", new ApplicationBatch());

		return "selenium/batchinfoform";
	}


	/**
	 * 
	 * @param dto configuration detail for the batch application process
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/batchapplicationsconf")
	public String postbatchapplicationconf(@ModelAttribute("batchForm") ApplicationBatch dto, BindingResult bindingResult) {


		try {
			initiateAutoPilotMeroshare(dto);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		autopilot.


		System.out.println("Pause here or just proceed");

		return "redirect:/batchapplicationsconf";
	}



}
