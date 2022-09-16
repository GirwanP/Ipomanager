package com.gp.ipomanager.entities;

import javax.persistence.*;

import com.gp.ipomanager.enums.AmountBlockerType;


@Entity
@Table(name = "AmountBlocker")
public class AmountBlocker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  private AmountBlockerType type;
  private Double amount;
  
  @OneToOne
  private AmountBlocker  preceedingBlocker;// for release relate to original blocker
  
  @ManyToOne
  private IPOApplication forApplication;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public AmountBlockerType getType() {
	return type;
}

public void setType(AmountBlockerType type) {
	this.type = type;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

public AmountBlocker getPreceedingBlocker() {
	return preceedingBlocker;
}

public void setPreceedingBlocker(AmountBlocker preceedingBlocker) {
	this.preceedingBlocker = preceedingBlocker;
}

public IPOApplication getForApplication() {
	return forApplication;
}

public void setForApplication(IPOApplication forApplication) {
	this.forApplication = forApplication;
}
  
    
    
    
}
