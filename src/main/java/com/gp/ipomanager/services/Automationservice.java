package com.gp.ipomanager.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gp.ipomanager.dto.InteractiveCommandParamsDto;
import com.gp.ipomanager.enums.BrowserType;

public interface Automationservice {


	public WebDriver getDriver(String url,BrowserType browser);

//	public boolean executeDefault(WebDriver driver) ;
//	public WebElement executeNextFromData(long searchParamId,WebDriver driver) throws Exception ;	
//	public WebElement executeInteractiveReflection(InteractiveCommandParamsDto parameters,WebDriver driver) throws Exception ;

	public WebElement executeInteractiveManual(InteractiveCommandParamsDto parameters,WebDriver driver) throws Exception ;


}
