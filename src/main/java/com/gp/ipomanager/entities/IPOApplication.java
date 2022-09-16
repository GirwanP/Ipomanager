package com.gp.ipomanager.entities;

import javax.persistence.*;

import com.gp.ipomanager.enums.AmountStatus;

@Entity
@Table(name = "IPOApplication")
public class IPOApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Applicant applicant;
	@ManyToOne
	private IPOOpening  ipoIssue;

	private Integer appliedQuantity;
	private Double applicationAmount;


	private boolean applicationSubmitted;

	private boolean allotMentCompleted;


	private Integer allottedQuantity;
	private Double  amountToDeduct;//for allotment
	private Double amountToRelease;

	//   private boolean amountReleasedOrDeductedInRecord;
	private AmountStatus amountStatus; // only update status after some days
	private boolean allProcessCompleted;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public IPOOpening getIpoIssue() {
		return ipoIssue;
	}
	public void setIpoIssue(IPOOpening ipoIssue) {
		this.ipoIssue = ipoIssue;
	}
	public Integer getAppliedQuantity() {
		return appliedQuantity;
	}
	public void setAppliedQuantity(Integer appliedQuantity) {
		this.appliedQuantity = appliedQuantity;
	}
	public Double getApplicationAmount() {
		return applicationAmount;
	}
	public void setApplicationAmount(Double applicationAmount) {
		this.applicationAmount = applicationAmount;
	}
	public boolean isApplicationSubmitted() {
		return applicationSubmitted;
	}
	public void setApplicationSubmitted(boolean applicationSubmitted) {
		this.applicationSubmitted = applicationSubmitted;
	}
	public boolean isAllotMentCompleted() {
		return allotMentCompleted;
	}
	public void setAllotMentCompleted(boolean allotMentCompleted) {
		this.allotMentCompleted = allotMentCompleted;
	}
	public Integer getAllottedQuantity() {
		return allottedQuantity;
	}
	public void setAllottedQuantity(Integer allottedQuantity) {
		this.allottedQuantity = allottedQuantity;
	}
	public Double getAmountToDeduct() {
		return amountToDeduct;
	}
	public void setAmountToDeduct(Double amountToDeduct) {
		this.amountToDeduct = amountToDeduct;
	}
	public Double getAmountToRelease() {
		return amountToRelease;
	}
	public void setAmountToRelease(Double amountToRelease) {
		this.amountToRelease = amountToRelease;
	}
	public AmountStatus getAmountStatus() {
		return amountStatus;
	}
	public void setAmountStatus(AmountStatus amountStatus) {
		this.amountStatus = amountStatus;
	}
	public boolean isAllProcessCompleted() {
		return allProcessCompleted;
	}
	public void setAllProcessCompleted(boolean allProcessCompleted) {
		this.allProcessCompleted = allProcessCompleted;
	}





}
