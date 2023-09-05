package com.bts.poc.facture;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;
import com.bts.poc.facture.service.IFactureService;
import com.bts.poc.facture.service.sequenceGeneratorService;

@DataMongoTest

//Unit Testing Rest API using JUnit 5
class FactureRepositoryUnitTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	

@Autowired
private IFactureRepository factureRepository ;


@Test
void findAllFacture() {
	
	//When
	 List<Facture> factures = this.factureRepository.findAll();
	
	//then
	 // test ok
	 assertEquals(8, factures.size() );
	 
	 //  test ok (failed)
	// assertEquals(2, factures.size() );
}


@Test
void findById_should_return_facture() {
	//When
	Optional<Facture> facture = this.factureRepository.findById(3L);
	
	//Then 
	// test ok
	assertTrue(facture.isPresent());
	// je teste si la valeur nexiste pas
	//assertTrue(facture.isEmpty());
}

@Test
void save_should_insert_new_facture() {
    // Given  (Arrange)
    Facture newFacture = new Facture();
    newFacture.setLibelle("Libelle facture TEST");
    newFacture.setMontant(2500F);
    newFacture.setClient("Client Test");
    newFacture.setId(5L);
    
   
    // When  (Act)
   
    Facture persistedFacture = this.factureRepository.save(newFacture);
    
    // Then (Assert)
    assertNotNull(persistedFacture);
    assertEquals(5, persistedFacture.getId());
}


@Test
void save_should_update_existing_facture() {
    // Given
	Facture existingFacture = new Facture();
	existingFacture.setId(3L);;
	existingFacture.setLibelle("FIRST Libelle");
	existingFacture.setClient("FIRST Client");
	existingFacture.setMontant(4500F);
	
    // When
    Facture updatedFacture = this.factureRepository.save(existingFacture);
    
    // Then
    assertNotNull(updatedFacture);
    assertEquals("FIRST Libelle", updatedFacture.getLibelle());
    assertEquals("FIRST Client", updatedFacture.getClient());
    assertEquals(4500F, updatedFacture.getMontant());
}

@Test
void deleteById_should_delete_facture() {
    // When
    this.factureRepository.deleteById(2L);
    Optional<Facture> facture = this.factureRepository.findById(2L);
    // Then
    assertFalse(facture.isPresent());
}


}
