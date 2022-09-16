package com.gp.ipomanager.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "OperationTemplate")
public class OperationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String operationTemplateName;
    
    @OneToMany(fetch = FetchType.EAGER) 
    private List<ActionParam> actions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperationTemplateName() {
		return operationTemplateName;
	}

	public void setOperationTemplateName(String operationTemplateName) {
		this.operationTemplateName = operationTemplateName;
	}

	public List<ActionParam> getActions() {
		return actions;
	}

	public void setActions(List<ActionParam> actions) {
		this.actions = actions;
	}
   
    
    
}
