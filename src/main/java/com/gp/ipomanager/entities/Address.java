package com.gp.ipomanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.gp.ipomanager.enums.AddressType;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	AddressType addressType;
	
	private String country;
	private String state;
	private String district;
	private String municipalty;
	private String wardNo;
	private String street;
	private String tole;
	
	
	
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWardNo() {
		return wardNo;
	}
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTole() {
		return tole;
	}
	public void setTole(String tole) {
		this.tole = tole;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMunicipalty() {
		return municipalty;
	}
	public void setMunicipalty(String municipalty) {
		this.municipalty = municipalty;
	}
	
	
}
