package com.gp.ipomanager.servicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atMost;

import java.util.Optional;

import org.mockito.junit.MockitoJUnitRunner;

import com.gp.ipomanager.entities.DmatAccount;
import com.gp.ipomanager.repository.ApplicantRepository;
import com.gp.ipomanager.repository.DmatRepository;


//@RunWith(mockito)
@RunWith(MockitoJUnitRunner.class)
class ApplicantsServiceImplTest {

	
//	 @Mock annotation is used to create the mock object to be injected
	   @Mock
	   ApplicantRepository applicantrepo;
	   @Mock
	   DmatRepository dmatrepo;
	   
	//@InjectMocks annotation is used to create and inject the mock object
	   @InjectMocks 
	   ApplicantsServiceImpl applicationService = new ApplicantsServiceImpl();


	
	@BeforeEach
		void  init() {
//		dmatrepo=mock(DmatRepository.class);	
		System.out.println("nn");
		}
	
	
	
	
	 //execute before class
	   @BeforeAll
	   public static void beforeClass() {
	      System.out.println("in before class");
	   }

	   //execute after class
	   @AfterAll
	   public static void  afterClass() {
	      System.out.println("in after class");
	   }

	   //execute before test
	   @BeforeEach
	   public void before() {
	      System.out.println("in before");
	   }
		
	   //execute after test
	   @AfterEach
	   public void after() {
	      System.out.println("in after");
	   }
		
	  
		
	   //test case ignore and will not execute
//	   @Ignore --junit 4
	   @Disabled //junit jupyter
	   public void ignoreTest() {
	      System.out.println("in ignore test");
	   }

	   @Disabled
	   @Test
		void test() {
//			fail("Not yet implemented");
//		   Assertions.
//		assertTrue(true);	
		}
	   
	   @Test
	   void testgetDematDetail() {
//		   DmatRepository dmatRepository= mock(DmatRepository.class);
		   
		   
		   DmatAccount dto= new DmatAccount();
		   dto.setCrnNo("2345");
			dto.setDpId("11800");
			dto.setdPName("Online Security");
			dto.setId(10l);
			dto.setMerosharePassword("12345");
			dto.setMeroshareUserId("123");
			dto.setMerosharePin("5212");
		   
		   when(dmatrepo.getForApplicant(10l)).thenReturn(Optional.ofNullable(dto));
//			when(dmatRepository.getForApplicant(10l).get().getId()).thenReturn(10l);
			   
		   assertEquals(10l,applicationService.getDematDetail(10l).getId() );
//		   DmatAccountDTO rdto= applicationService.getDematDetail(10l);
		   
//		   assertEquals(10l, rdto.getId());
//		   assertEquals("2345", rdto.getCrnNo());
		   
		   verify(dmatrepo, atMost(2)).getForApplicant(10l);  
		   
	   }
	   
	   
} 
