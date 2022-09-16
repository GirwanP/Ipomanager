package com.gp.ipomanager.entities;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "IPOOpening")
public class IPOOpening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
  private String companyName;
  private String companySymbol;// may not be same as script symbol
  private Integer minimumQuantityToApply;
  
  private Integer recommendedQuantityToApply;
  
  private Double pricePerKitta;
  private String issueManager;
  private Date openingDate;
  private Date soonerClosingDate;
  private Date  delayedClosingDate;
  
  private boolean allotMentCompleted;// release amount after this--means result is out
  private Date allotmentResultDate;
  
  private boolean amountStatusUpdated;// block/release of amount-- use for updating amount after 5 days of allotment completion date
  
  /*
   * this indicate active status
   */
  private boolean issueOpen;
  
  

public Integer getRecommendedQuantityToApply() {
	return recommendedQuantityToApply;
}

public void setRecommendedQuantityToApply(Integer recommendedQuantityToApply) {
	this.recommendedQuantityToApply = recommendedQuantityToApply;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getCompanySymbol() {
	return companySymbol;
}

public void setCompanySymbol(String companySymbol) {
	this.companySymbol = companySymbol;
}

public Integer getMinimumQuantityToApply() {
	return minimumQuantityToApply;
}

public void setMinimumQuantityToApply(Integer minimumQuantityToApply) {
	this.minimumQuantityToApply = minimumQuantityToApply;
}

public Double getPricePerKitta() {
	return pricePerKitta;
}

public void setPricePerKitta(Double pricePerKitta) {
	this.pricePerKitta = pricePerKitta;
}

public String getIssueManager() {
	return issueManager;
}

public void setIssueManager(String issueManager) {
	this.issueManager = issueManager;
}

public Date getOpeningDate() {
	return openingDate;
}

public void setOpeningDate(Date openingDate) {
	this.openingDate = openingDate;
}

public Date getSoonerClosingDate() {
	return soonerClosingDate;
}

public void setSoonerClosingDate(Date soonerClosingDate) {
	this.soonerClosingDate = soonerClosingDate;
}

public Date getDelayedClosingDate() {
	return delayedClosingDate;
}

public void setDelayedClosingDate(Date delayedClosingDate) {
	this.delayedClosingDate = delayedClosingDate;
}

public boolean isAllotMentCompleted() {
	return allotMentCompleted;
}

public void setAllotMentCompleted(boolean allotMentCompleted) {
	this.allotMentCompleted = allotMentCompleted;
}

public Date getAllotmentResultDate() {
	return allotmentResultDate;
}

public void setAllotmentResultDate(Date allotmentResultDate) {
	this.allotmentResultDate = allotmentResultDate;
}

public boolean isAmountStatusUpdated() {
	return amountStatusUpdated;
}

public void setAmountStatusUpdated(boolean amountStatusUpdated) {
	this.amountStatusUpdated = amountStatusUpdated;
}

public boolean isIssueOpen() {
	return issueOpen;
}

public void setIssueOpen(boolean issueOpen) {
	this.issueOpen = issueOpen;
}
    
    
  
    
    
}
