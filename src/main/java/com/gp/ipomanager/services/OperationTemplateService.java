package com.gp.ipomanager.services;

import java.util.List;

import com.gp.ipomanager.entities.ActionParam;
import com.gp.ipomanager.entities.OperationTemplate;

public interface OperationTemplateService {


	public OperationTemplate addNewOperationTemplate(OperationTemplate template);
	
	public OperationTemplate getOperationTemplate(long templateId);
	
	public List<OperationTemplate> getAllTemplates();
	
	public List<ActionParam> getActionParams(long templateId);
	
	public boolean addNewActionParam(long templateId,ActionParam param);
	public boolean addNextActionParam(long templateId,ActionParam param);
	
	public ActionParam getActionParam(long paramId);
	
	public ActionParam editActionParam(ActionParam param);
	
	public Integer changeorder(long paramid,Integer newOrder);
	
	public boolean deleteActionParam(long paramid);
	
	
}
