package com.gp.ipomanager.entities;

import javax.persistence.*;
import com.gp.ipomanager.enums.BankAccountType;


@Entity
@Table(name = "BankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CRN;
    
   private String bankName;
   private String branch;
   private String accountName;
   private String accountNumber;
   
   private Double bankBalance;
   private Double blockedAmount;
   private Double avalableAmount;
   
   private BankAccountType accountType;
   
   
   
   

public String getCRN() {
	return CRN;
}

public void setCRN(String cRN) {
	CRN = cRN;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getAccountName() {
	return accountName;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public Double getBankBalance() {
	return bankBalance;
}

public void setBankBalance(Double bankBalance) {
	this.bankBalance = bankBalance;
}

public Double getBlockedAmount() {
	return blockedAmount;
}

public void setBlockedAmount(Double blockedAmount) {
	this.blockedAmount = blockedAmount;
}

public Double getAvalableAmount() {
	return avalableAmount;
}

public void setAvalableAmount(Double avalableAmount) {
	this.avalableAmount = avalableAmount;
}

public BankAccountType getAccountType() {
	return accountType;
}

public void setAccountType(BankAccountType accountType) {
	this.accountType = accountType;
}
  
   
   
    
    
    
    
    
}
