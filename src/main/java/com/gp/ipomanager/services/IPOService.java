package com.gp.ipomanager.services;

import java.util.List;

import com.gp.ipomanager.dto.IPOOpeningDTO;

public interface IPOService {

	/***
	 * 
	 * @return list of ipo openings that are not expired/marked by active, status changed after all applicants apply for it.
	 */
	public List<IPOOpeningDTO> getActiveIPOs();
	
	public IPOOpeningDTO registerNewIPOOPening(IPOOpeningDTO ipo);
	
	public boolean markIPOInactive(long ipoId);
	
	public IPOOpeningDTO getIpo(long ipoId);
	
	public IPOOpeningDTO ediIPO(IPOOpeningDTO ipo);
	
	
}
