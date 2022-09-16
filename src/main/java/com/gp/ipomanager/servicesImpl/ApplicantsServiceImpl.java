package com.gp.ipomanager.servicesImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.ipomanager.dto.ApplicantDTO;
import com.gp.ipomanager.dto.DmatAccountDTO;
import com.gp.ipomanager.entities.Applicant;
import com.gp.ipomanager.entities.DmatAccount;
import com.gp.ipomanager.repository.ApplicantRepository;
import com.gp.ipomanager.repository.DmatRepository;
import com.gp.ipomanager.services.ApplicantsServices;

@Service
public class ApplicantsServiceImpl implements ApplicantsServices {

	@Autowired
	ApplicantRepository applicantrepo;
	@Autowired
	DmatRepository dmatrepo;

	private ApplicantDTO getDto(Applicant applicant) {
		ApplicantDTO dto = new ApplicantDTO();
		dto.setApplicantName(applicant.getApplicantName());
		dto.setId(applicant.getId());
		return dto;
	}

	private Applicant getentity(ApplicantDTO dto) {
		Applicant a = new Applicant();
		a.setApplicantName(dto.getApplicantName());
		a.setDisabled(false);
//		a.se
		return a;

	}

	private DmatAccountDTO getDmatdto(DmatAccount acc) {

		DmatAccountDTO dto = new DmatAccountDTO();

		dto.setApplicantId(acc.getApplicant().getId());
		dto.setCrnNo(acc.getCrnNo());
		dto.setDpId(acc.getDpId());
		dto.setdPName(acc.getdPName());
		dto.setId(acc.getId());
		dto.setMerosharePassword(acc.getMerosharePassword());
		dto.setMeroshareUserId(acc.getMeroshareUserId());
		dto.setMerosharePin(acc.getMerosharePin());

		return dto;
	}

	private DmatAccount getdmatentity(DmatAccountDTO acc) {

		DmatAccount dto = new DmatAccount();

//		dto.setApplicantId(acc.getApplicant().getId());
		dto.setCrnNo(acc.getCrnNo());
		dto.setDpId(acc.getDpId());
		dto.setdPName(acc.getdPName());
		dto.setId(acc.getId());
		dto.setMerosharePassword(acc.getMerosharePassword());
		dto.setMeroshareUserId(acc.getMeroshareUserId());
		dto.setMerosharePin(acc.getMerosharePin());

		return dto;
	}
	
	private DmatAccount transferInto(DmatAccountDTO dto,DmatAccount acc) {
		
		for(Field f:dto.getClass().getDeclaredFields()) {
			
			try {
				Field f1=acc.getClass().getDeclaredField(f.getName());
				f.setAccessible(true);
				f1.setAccessible(true);
				f1.set(acc, f.get(dto));
				f1.setAccessible(false);
				f.setAccessible(false);
				
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return acc;
		
	}

	@Override
	public List<ApplicantDTO> getActiveApplicants() {

		List<Applicant> list = applicantrepo.getAllApplicantsByStatus(false);

		List<ApplicantDTO> dtos = new ArrayList<ApplicantDTO>();
		for (Applicant a : list) {
			dtos.add(getDto(a));
		}

		return dtos;
	}

	@Override
	public boolean inactivateApplicant(Long applicantId) {

		Optional<Applicant> a = applicantrepo.findById(applicantId);

		if (a.isPresent()) {
			Applicant aa = a.get();
			aa.setDisabled(true);
			applicantrepo.save(aa);
			return true;
		}
		return false;
	}

	@Override
	public boolean activateApplicant(long applicantId) {

		Optional<Applicant> a = applicantrepo.findById(applicantId);

		if (a.isPresent()) {
			Applicant aa = a.get();
			aa.setDisabled(false);
			applicantrepo.save(aa);
			return true;
		}
		return false;
	}

	@Override
	public boolean addNewApplicant(ApplicantDTO applicant) {

		Applicant a = getentity(applicant);
		a = applicantrepo.save(a);

		return true;
	}

	@Override
	public DmatAccountDTO getDematDetail(long applicantId) {
		Optional<DmatAccount> acc = dmatrepo.getForApplicant(applicantId);
		if (acc.isPresent()) {
			System.out.println("ut");
			DmatAccountDTO dto = getDmatdto(acc.get());
			return dto;
		}

		return null;
	}

	@Override
	public Optional<DmatAccountDTO> getDematDetail1(long applicantId) {
		Optional<DmatAccount> acc = dmatrepo.getForApplicant(applicantId);
		Optional<DmatAccountDTO> acd;// = Optional.ofNullable(acc.get());
		if (acc.isPresent()) {
			DmatAccountDTO dto = getDmatdto(acc.get());
			acd = Optional.ofNullable(dto);
			return acd;
		}

		return Optional.ofNullable(null);
	}

	@Override
	public boolean addDematInfo(long applicantId, DmatAccountDTO account) {

		DmatAccount acc = getdmatentity(account);
		Optional<Applicant> a = applicantrepo.findById(applicantId);

		if (a.isPresent()) {
			Applicant aa = a.get();
			acc.setApplicant(aa);
			acc = dmatrepo.save(acc);
			aa.setMeroshare(acc);
			return true;
		}
		return false;
	}

	@Override
	public ApplicantDTO getApplicant(Long appLicantId) {

		Optional<Applicant> a = applicantrepo.findById(appLicantId);
		if (a.isPresent()) {
			return getDto(a.get());
		}

		return null;
	}

	@Override
	public boolean editDematInfo( DmatAccountDTO account) {
		
		Optional<DmatAccount> acc = dmatrepo.getForApplicant(account.getApplicantId());
		
//		Optional<Applicant> a = applicantrepo.findById(account.getApplicantId());

		DmatAccount acca=transferInto(account, acc.get());
		
			acca = dmatrepo.save(acca);
			return true;
		
	}

}
