package com.gp.ipomanager.services;

import java.util.List;
import java.util.Optional;

import com.gp.ipomanager.dto.ApplicantDTO;
import com.gp.ipomanager.dto.DmatAccountDTO;

public interface ApplicantsServices {

	
	/***
	 * 
	 * @return List of applicants that are not currently disabled
	 */
	public List<ApplicantDTO> getActiveApplicants();
	
	public ApplicantDTO getApplicant(Long appLicantId);
	
	public boolean inactivateApplicant(Long applicantId);
	
	public boolean activateApplicant(long applicantId);
	
	public boolean addNewApplicant(ApplicantDTO applicant);
	
	public DmatAccountDTO getDematDetail(long applicantId);
	
	public boolean addDematInfo(long applicantId,DmatAccountDTO account);
	public boolean editDematInfo(DmatAccountDTO account);
	

	Optional<DmatAccountDTO> getDematDetail1(long applicantId);
	
	
}
