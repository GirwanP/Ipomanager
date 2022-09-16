package com.gp.ipomanager.dto;


public class ApplicationQuantity {
   
	private boolean apply;
	private Long applicantId;
	private Integer kittaToApply;
	
	
	public boolean isApply() {
		return apply;
	}
	public void setApply(boolean apply) {
		this.apply = apply;
	}
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public Integer getKittaToApply() {
		return kittaToApply;
	}
	public void setKittaToApply(Integer kittaToApply) {
		this.kittaToApply = kittaToApply;
	}
    
}
