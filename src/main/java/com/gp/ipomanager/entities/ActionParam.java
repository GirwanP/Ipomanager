package com.gp.ipomanager.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gp.ipomanager.enums.ByType;
import com.gp.ipomanager.enums.PathParamType;
import com.gp.ipomanager.enums.WebElementActions;

@Entity
public class ActionParam {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private  ByType bytype;
    
    private String pathStringHead;
    private String pathParam;
    private String pathStringTail;
    private PathParamType pathParamType;
    private String xpParamName;
    
    private WebElementActions actiontype;
    private Integer actionOrder;
    private String ipParamName;
    
	public String getXpParamName() {
		return xpParamName;
	}

	public void setXpParamName(String xpParamName) {
		this.xpParamName = xpParamName;
	}

	public String getIpParamName() {
		return ipParamName;
	}

	public void setIpParamName(String ipParamName) {
		this.ipParamName = ipParamName;
	}

	public CharSequence getPathStringHead() {
		return pathStringHead;
	}

	public void setPathStringHead(String pathStringHead) {
		this.pathStringHead = pathStringHead;
	}

	public CharSequence getPathParam() {
		return pathParam;
	}

	public void setPathParam(String pathParam) {
		this.pathParam = pathParam;
	}

	public CharSequence getPathStringTail() {
		return pathStringTail;
	}

	public void setPathStringTail(String pathStringTail) {
		this.pathStringTail = pathStringTail;
	}

	public PathParamType getPathParamType() {
		return pathParamType;
	}

	public void setPathParamType(PathParamType pathParamType) {
		this.pathParamType = pathParamType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ByType getBytype() {
		return bytype;
	}

	public void setBytype(ByType bytype) {
		this.bytype = bytype;
	}

	

	public WebElementActions getActiontype() {
		return actiontype;
	}

	public void setActiontype(WebElementActions actiontype) {
		this.actiontype = actiontype;
	}

	public Integer getActionOrder() {
		return actionOrder;
	}

	public void setActionOrder(Integer actionOrder) {
		this.actionOrder = actionOrder;
	}

    
}
