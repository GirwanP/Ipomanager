package com.gp.ipomanager.dto;



public class DmatAccountDTO {

	private Long id;

    private Long applicantId;
   
    private String meroshareUserId;
    private String merosharePassword;
    private String merosharePin;
    private String dpId;
    private String crnNo;
    
    private String dPName;
    private String dPNumber;
    
    
    
	public String getDpId() {
		return dpId;
	}
	public void setDpId(String dpId) {
		this.dpId = dpId;
	}
	public String getCrnNo() {
		return crnNo;
	}
	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public String getMeroshareUserId() {
		return meroshareUserId;
	}
	public void setMeroshareUserId(String meroshareUserId) {
		this.meroshareUserId = meroshareUserId;
	}
	public String getMerosharePassword() {
		return merosharePassword;
	}
	public void setMerosharePassword(String merosharePassword) {
		this.merosharePassword = merosharePassword;
	}
	public String getMerosharePin() {
		return merosharePin;
	}
	public void setMerosharePin(String merosharePin) {
		this.merosharePin = merosharePin;
	}
	public String getdPName() {
		return dPName;
	}
	public void setdPName(String dPName) {
		this.dPName = dPName;
	}
	public String getdPNumber() {
		return dPNumber;
	}
	public void setdPNumber(String dPNumber) {
		this.dPNumber = dPNumber;
	}
    
  
   
   
    
    
    
    
    
}
