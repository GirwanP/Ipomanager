package com.gp.ipomanager.servicesImpl;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.springframework.stereotype.Service;

import com.gp.ipomanager.dto.InteractiveCommandParamsDto;
import com.gp.ipomanager.enums.BrowserType;
import com.gp.ipomanager.enums.WebElementActions;
import com.gp.ipomanager.services.Automationservice;

@Service
public class AutomationserviceImpl implements Automationservice{


	public WebDriver getDriver(String url,BrowserType browser) {

		String Path_of_Firefox_Driver ="E:\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",Path_of_Firefox_Driver); // Setting system properties of FirefoxDriver

		WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}




	public WebElement executeInteractiveManual(InteractiveCommandParamsDto parameters,WebDriver driver) throws Exception {
		WebElement e1;

		for(Method m:By.class.getDeclaredMethods()) {
			if(m.getName().equals(parameters.getBytype().toString())) {
				By by=(By)m.invoke(null, parameters.getPathString());
				e1=driver.findElement(by);

				System.out.println("tag: "+e1.getTagName());

				if(parameters.getActiontype().equals(WebElementActions.sendKeys)) {
					e1.sendKeys(parameters.getParam1());
				}else if(parameters.getActiontype().equals(WebElementActions.click)) {
					e1.click();
				}else if(parameters.getActiontype().equals(WebElementActions.submit)) {

				}


			}
		}
		throw new Exception();
	}


}
