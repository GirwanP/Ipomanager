package com.gp.ipomanager.entities;

import javax.persistence.*;

@Entity
@Table(name = "Applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER)
    ApplicantProfile profile;
  
    private String applicantName;
    
    @OneToOne
    private DmatAccount meroshare;
    
    private boolean disabled;
    

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public DmatAccount getMeroshare() {
		return meroshare;
	}

	public void setMeroshare(DmatAccount meroshare) {
		this.meroshare = meroshare;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApplicantProfile getProfile() {
		return profile;
	}

	public void setProfile(ApplicantProfile profile) {
		this.profile = profile;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
    
    
    
}
