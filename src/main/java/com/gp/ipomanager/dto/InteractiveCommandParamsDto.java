package com.gp.ipomanager.dto;

import com.gp.ipomanager.enums.ByType;
import com.gp.ipomanager.enums.WebElementActions;

public class InteractiveCommandParamsDto {
  
    private  ByType bytype;
    private CharSequence pathString;
    
    private WebElementActions actiontype;
    
    private  String param1;
    
    
	public ByType getBytype() {
		return bytype;
	}
	public void setBytype(ByType bytype) {
		this.bytype = bytype;
	}
	
	public CharSequence getPathString() {
		return pathString;
	}
	public void setPathString(CharSequence pathString) {
		this.pathString = pathString;
	}
	public WebElementActions getActiontype() {
		return actiontype;
	}
	public void setActiontype(WebElementActions actiontype) {
		this.actiontype = actiontype;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	
    
    
	 
    
	
    
    
    
}
