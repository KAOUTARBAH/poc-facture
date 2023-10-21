package com.bts.poc.facture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;
import com.bts.poc.facture.service.FactureService;

@ExtendWith(MockitoExtension.class)
class FactureServiceUnitTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	/*
	 * @Mock allows us to create and inject a mock of FactureRepository
	 * @InjectMocks is used to create an instance of our service FactureService so that we can test it
	 * Now, let’s exemplify the use of Mockito and JUnit 5 to test our service:
	 * */
	@Mock
	private IFactureRepository factureRepository;
	
	
	
	@InjectMocks
	private FactureService factureService;
	
	
	
	
	@Test 
	void findAllInvioces() {
		 // Given
        //Facture facture = this.buildTestingFacture();
		List<Facture> factureList = this.buildTestingFactures();
       
        // When
        when(factureRepository.findAll()).thenReturn((factureList));
        List<Facture> facturesService = this.factureService.getAllFacture();
       
        // Then
        assertEquals(2, facturesService.size());
        verify(this.factureRepository).findAll();
		
	}
	
	@Test 
	void getInvioceById() {
		 // Given
        Facture facture = this.buildTestingFacture();
       
        // When
        when(factureRepository.findById(1L)).thenReturn(Optional.of(facture));
        Facture facturesServiceById = this.factureService.getFacture(1L);
       
        // Then
        assertEquals(facture.getId(), facturesServiceById.getId());
        verify(this.factureRepository).findById(1L);
		
	}
	
	@Test 
	void saveInvioce() {
		 // Given
        Facture facture = this.buildTestingFacture();
        //facture.setId(sequenceGeneratorService.generateSequence(facture.SEQUENCE_NAME));
        facture.setId(2L);
       
        // When 
       //facture.setId(sequenceGeneratorService.generateSequence(facture.SEQUENCE_NAME));
       System.out.println("********** TEST ********");
       System.out.println(facture.getCustomerRef());
        System.out.println(facture.getId());
       
        System.out.println("********** TEST ********");
        //this.factureRepository.save(facture);
        this.factureService.saveFacture(facture);
       
        // Then      
        verify(this.factureRepository).save(facture);
		
	}
	
	  @Test
      void deleteByIdFacture() {
          // When
          this.factureService.deleteFacture(2L);
          // Then
          verify(this.factureRepository).deleteById(2L);
      }
	
	
	
	 private Facture buildTestingFacture() {
		 Facture facture = new Facture();		 
		
		 facture.setCustomerRef("FIRST_NAME");
		 facture.setCustomerContact("LAST_NAME@gmail.com");
		 //facture.setMontant(3000F);
		
       return facture;
     }
	
	 private List<Facture> buildTestingFactures() {
		 Facture facture = new Facture();
		 facture.setId(1L);
		 facture.setCustomerRef("FIRST_NAME");
		 facture.setCustomerContact("LAST_NAME");
		// facture.setMontant(3000F);
		 
		 Facture facture2 = new Facture();
		 facture.setId(2L);
		 facture.setCustomerRef("FIRST_NAME2");
		 facture.setCustomerContact("LAST_NAME2");
		 //facture.setMontant(2000F);
		 
		 List<Facture> factures = new ArrayList<>();
		 factures.add(facture);
		 factures.add(facture2);
		 
         return factures;
     }

}
