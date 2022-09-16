package com.gp.ipomanager.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.ipomanager.dto.IPOOpeningDTO;
import com.gp.ipomanager.entities.IPOOpening;
import com.gp.ipomanager.repository.IpoOpeningRepository;
import com.gp.ipomanager.services.IPOService;

@Service
public class IPOServiceImpl implements IPOService{

	@Autowired
	IpoOpeningRepository iporepository;
	
	private IPOOpeningDTO convertToIPODto(IPOOpening ipo) {
		IPOOpeningDTO dto=new IPOOpeningDTO();
		dto.setId(ipo.getId());
		dto.setCompanyName(ipo.getCompanyName());
		dto.setCompanySymbol(ipo.getCompanySymbol());
		dto.setMinimumQuantityToApply(ipo.getMinimumQuantityToApply());
		dto.setRecommendedQuantityToApply(ipo.getRecommendedQuantityToApply());
		dto.setPricePerKitta(ipo.getPricePerKitta());
//		dto.set
		return dto;
	}
	
	
	private IPOOpening convertToIPO(IPOOpeningDTO ipo) {
		
		IPOOpening dto=new IPOOpening();
		
		dto.setId(ipo.getId());
		dto.setCompanyName(ipo.getCompanyName());
		dto.setCompanySymbol(ipo.getCompanySymbol());
		dto.setMinimumQuantityToApply(ipo.getMinimumQuantityToApply());
		dto.setRecommendedQuantityToApply(ipo.getRecommendedQuantityToApply());
		dto.setPricePerKitta(ipo.getPricePerKitta());
//		dto.set
		return dto;
	}
	
	
	@Override
	public List<IPOOpeningDTO> getActiveIPOs() {
		List<IPOOpening> ipos=iporepository.getAllIPOOpeningsByStatus(true);
		
		List<IPOOpeningDTO> dtolist=new ArrayList<IPOOpeningDTO>();
		for (IPOOpening ipoOpening : ipos) {
			dtolist.add(convertToIPODto(ipoOpening));
		}
		
		
		return dtolist;
	}

	@Override
	public IPOOpeningDTO registerNewIPOOPening(IPOOpeningDTO ipo) {
		IPOOpening ipoe=convertToIPO(ipo);
		ipoe.setIssueOpen(true);
		iporepository.save(ipoe);
		
		return ipo;
	}

	@Override
	public boolean markIPOInactive(long ipoId) {
		Optional<IPOOpening> ipo=iporepository.findById(ipoId);
		if(ipo.isPresent()) {
			IPOOpening ip=ipo.get();
			ip.setIssueOpen(false);
			iporepository.save(ip);
			return true;
		}		
		
		return false;
	}

	@Override
	public IPOOpeningDTO getIpo(long ipoId) {
		Optional<IPOOpening> ipo=iporepository.findById(ipoId);
		if(ipo.isPresent()) {
			IPOOpening ip=ipo.get();
			
			return convertToIPODto(ip);
		}	
		return null;
	}

	@Override
	public IPOOpeningDTO ediIPO(IPOOpeningDTO ipo) {
		Optional<IPOOpening> ipoo=iporepository.findById(ipo.getId());
		if(ipoo.isPresent()) {
			
			IPOOpening ip=convertToIPO(ipo);
			
			ip.setId(ipoo.get().getId());
			
			iporepository.save(ip);
			return ipo;
		}	
		
		
		return null;
	}
	
}
