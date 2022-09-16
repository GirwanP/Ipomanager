package com.gp.ipomanager.entities;

import javax.persistence.*;

import com.gp.ipomanager.enums.LedgerType;

@Entity
@Table(name = "Ledger")
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 private Double amount;
 private LedgerType ledgerType;
 private Double previousBalance;
 private Double newBalance;
  
 @ManyToOne
 Transaction transaction;
 
 @ManyToOne
 BankAccount bankAccount;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

public LedgerType getLedgerType() {
	return ledgerType;
}

public void setLedgerType(LedgerType ledgerType) {
	this.ledgerType = ledgerType;
}

public Double getPreviousBalance() {
	return previousBalance;
}

public void setPreviousBalance(Double previousBalance) {
	this.previousBalance = previousBalance;
}

public Double getNewBalance() {
	return newBalance;
}

public void setNewBalance(Double newBalance) {
	this.newBalance = newBalance;
}

public Transaction getTransaction() {
	return transaction;
}

public void setTransaction(Transaction transaction) {
	this.transaction = transaction;
}

public BankAccount getBankAccount() {
	return bankAccount;
}

public void setBankAccount(BankAccount bankAccount) {
	this.bankAccount = bankAccount;
}
 
 
 
    
    
    
}
