package com.gp.ipomanager.entities;

import javax.persistence.*;


@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 private Double amount;
 @OneToOne
 private BankAccount fromAccount;
 @OneToOne
 private BankAccount toAccount;
 
 @ManyToOne
 private IPOApplication application;

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

public BankAccount getFromAccount() {
	return fromAccount;
}

public void setFromAccount(BankAccount fromAccount) {
	this.fromAccount = fromAccount;
}

public BankAccount getToAccount() {
	return toAccount;
}

public void setToAccount(BankAccount toAccount) {
	this.toAccount = toAccount;
}

public IPOApplication getApplication() {
	return application;
}

public void setApplication(IPOApplication application) {
	this.application = application;
}
  
    
 
 
    
}
