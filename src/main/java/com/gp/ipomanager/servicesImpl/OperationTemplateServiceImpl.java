package com.gp.ipomanager.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.ipomanager.entities.ActionParam;
import com.gp.ipomanager.entities.OperationTemplate;
import com.gp.ipomanager.repository.ActionParamsRepository;
import com.gp.ipomanager.repository.OperationTemplateRepository;
import com.gp.ipomanager.services.OperationTemplateService;

@Service
public class OperationTemplateServiceImpl implements OperationTemplateService{

	@Autowired
	OperationTemplateRepository otrepository;
	@Autowired
	ActionParamsRepository actionrepository;
	
	@Override
	public OperationTemplate addNewOperationTemplate(OperationTemplate template) {

		otrepository.save(template);
		return null;
	}

	@Override
	public OperationTemplate getOperationTemplate(long templateId) {
		Optional<OperationTemplate> temp=otrepository.findById(templateId);
		return temp.get();
	}

	@Override
	public List<OperationTemplate> getAllTemplates() {
		
		List<OperationTemplate> otlist=otrepository.findAll();
		
		
		return otlist;
	}

	@Override
	public List<ActionParam> getActionParams(long templateId) {
		
		List<ActionParam> params =otrepository.getActionParams(templateId);
		
		return params;
	}

	@Override
	public boolean addNewActionParam(long templateId, ActionParam param) {
		
		Optional<OperationTemplate> tempO= otrepository.findById(templateId);
		
		if(tempO.isPresent()) {
			OperationTemplate temp=tempO.get();
			
			List<ActionParam> params =temp.getActions(); //otrepository.getActionParams(templateId);
			
			param=actionrepository.save(param);
			params.add(param);
			
			temp.setActions(params);

			otrepository.save(temp);
		}
		return false;
	}

	@Override
	public boolean addNextActionParam(long templateId, ActionParam param) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ActionParam getActionParam(long paramId) {
		Optional<ActionParam> param= actionrepository.findById(paramId);
		
		return param.get();
	}

	@Override
	public ActionParam editActionParam(ActionParam param) {
		
//		Optional<ActionParam> paramO= actionrepository.findById(param.getId());
		actionrepository.save(param);
		
		return null;
	}

	@Override
	public Integer changeorder(long paramid, Integer newOrder) {
		Optional<ActionParam> paramO= actionrepository.findById(paramid);
		if(paramO.isPresent()) {
			ActionParam p=paramO.get();
			p.setActionOrder(newOrder);
			actionrepository.save(p);
			return newOrder;
		}
		
		return null;
	}

	@Override
	public boolean deleteActionParam(long paramid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
