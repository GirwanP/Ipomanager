package com.gp.ipomanager.dto;

import java.util.List;


public class ApplicationBatch {
   
	private Long ipoId;
	
	private long operationTemplateId;
	
    private boolean useDefaultQuantity;
    private Integer defaultQuantity;
    
    private List<ApplicationQuantity> quantities;

    
    
	public long getOperationTemplateId() {
		return operationTemplateId;
	}

	public void setOperationTemplateId(long operationTemplateId) {
		this.operationTemplateId = operationTemplateId;
	}

	public Long getIpoId() {
		return ipoId;
	}

	public void setIpoId(Long ipoId) {
		this.ipoId = ipoId;
	}

	public boolean isUseDefaultQuantity() {
		return useDefaultQuantity;
	}

	public void setUseDefaultQuantity(boolean useDefaultQuantity) {
		this.useDefaultQuantity = useDefaultQuantity;
	}

	public Integer getDefaultQuantity() {
		return defaultQuantity;
	}

	public void setDefaultQuantity(Integer defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}

	public List<ApplicationQuantity> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<ApplicationQuantity> quantities) {
		this.quantities = quantities;
	}
    
  
    
    
}
