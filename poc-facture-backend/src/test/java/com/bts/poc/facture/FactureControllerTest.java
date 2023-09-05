package com.bts.poc.facture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.bts.poc.facture.controller.IFactureController;
import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;

@SpringBootTest
class FactureControllerTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Autowired
	private IFactureRepository factureRepository;
	
	@Autowired
	private IFactureController factureCotroller;
	
	@Autowired
	public MockMvc mockMvc;
	
//	@Test
//	public void testCreateFacture() {
//		
//		//	Arrange (organiser) 
//		Facture facture1 = new Facture("Facture test libelle", 1200F, "Client Test");
//		Facture facture2 = new Facture("Facture test libelle2", 1500F, "Client Test2");
//		
//		
//		//  Act  (agir) 
//		factureCotroller.saveFacture(facture1);
//		factureCotroller.saveFacture(facture2);
//		
//		//test qui verifier le nombre des factures enregistré
//		//	Assert (vérifier) 
//		//test ok
//		assertEquals(2, factureCotroller.getAllFacture().size());
//		
//	}
//	
//	@Test 
//	public void testGetFacture() {
//		//		Arrange (organiser) 
//		//Facture factureTest = new Facture("Libelle ACHAT", 1200F, "Client Test3");
//		
//		//  Act  (agir) 
//		factureCotroller.saveFacture(factureTest);
//			
//		//		Assert (vérifier) 
//		//tester si libelle 1 EXISTE OU NON
//		//test ok
//		//assertEquals("Libelle ACHAT", factureTest.getLibelle());
//		
//		//test failed
//		//assertEquals("Libelle 2", factureTest.getLibelle());
//
//	}
//	
//	 @Test
//	 public void saveFacture() {
//		 //Arrange
//		 Facture  facture = new Facture();
//		 facture.setLibelle("Libelle facture TEST");
//		 facture.setMontant(2500F);
//		 facture.setClient("Client Test");
//		 
//		 
//		 //Act
//		 //Facture newFacture = factureRepository.save(facture);
//		 Facture newFacture = factureCotroller.saveFacture(facture);
//		 
//		 //Assert
////		 assertNotNull(newFacture);
////		 assertThat(newFacture.getId()).isNotEqualTo(null);
//	 }
}
