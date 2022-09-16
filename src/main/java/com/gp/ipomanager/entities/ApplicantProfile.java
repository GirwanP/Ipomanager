package com.gp.ipomanager.entities;

import javax.persistence.*;


@Entity
@Table(name = "ApplicantProfile")
public class ApplicantProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Applicant applicant;
    
   private String firstName;
   private String middleName;
   private String lastName;
   
   private String fathersName;
   private String mothersName;
   private String grandFathersName;
   private String grandMothersName;
   
   private String citizenshipNo;
   private String citizenshipIssueDate;
   private String passportNo;
   private String passportIssueDate;
   
   private String dateOfBirth;
   
   private String email;
   private String mobileNo;
   
   @OneToOne
   private Address temporaryAddress;
   @OneToOne
   private Address permanentAddress;
  
   @OneToOne
   private BankAccount IPOBankAccount;
   @OneToOne
   private BankAccount partnershiPPayingBankAccount;// pay at this account;
   
   
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
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFathersName() {
	return fathersName;
}
public void setFathersName(String fathersName) {
	this.fathersName = fathersName;
}
public String getMothersName() {
	return mothersName;
}
public void setMothersName(String mothersName) {
	this.mothersName = mothersName;
}
public String getGrandFathersName() {
	return grandFathersName;
}
public void setGrandFathersName(String grandFathersName) {
	this.grandFathersName = grandFathersName;
}
public String getGrandMothersName() {
	return grandMothersName;
}
public void setGrandMothersName(String grandMothersName) {
	this.grandMothersName = grandMothersName;
}
public String getCitizenshipNo() {
	return citizenshipNo;
}
public void setCitizenshipNo(String citizenshipNo) {
	this.citizenshipNo = citizenshipNo;
}
public String getCitizenshipIssueDate() {
	return citizenshipIssueDate;
}
public void setCitizenshipIssueDate(String citizenshipIssueDate) {
	this.citizenshipIssueDate = citizenshipIssueDate;
}
public String getPassportNo() {
	return passportNo;
}
public void setPassportNo(String passportNo) {
	this.passportNo = passportNo;
}
public String getPassportIssueDate() {
	return passportIssueDate;
}
public void setPassportIssueDate(String passportIssueDate) {
	this.passportIssueDate = passportIssueDate;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public Address getTemporaryAddress() {
	return temporaryAddress;
}
public void setTemporaryAddress(Address temporaryAddress) {
	this.temporaryAddress = temporaryAddress;
}
public Address getPermanentAddress() {
	return permanentAddress;
}
public void setPermanentAddress(Address permanentAddress) {
	this.permanentAddress = permanentAddress;
}
public BankAccount getIPOBankAccount() {
	return IPOBankAccount;
}
public void setIPOBankAccount(BankAccount iPOBankAccount) {
	IPOBankAccount = iPOBankAccount;
}
public BankAccount getPartnershiPPayingBankAccount() {
	return partnershiPPayingBankAccount;
}
public void setPartnershiPPayingBankAccount(BankAccount partnershiPPayingBankAccount) {
	this.partnershiPPayingBankAccount = partnershiPPayingBankAccount;
}
    
    
   
   
   
    
}
