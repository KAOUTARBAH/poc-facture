package com.bts.poc.facture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;

class FactureRepositoryTest {

	@Autowired
	private TestEntityManager entityManger;
	
	@Autowired
	private IFactureRepository factureRepository ;
	
	@Test
	void test() {
		//	Arrange (organiser) 
		Facture factureTest = new Facture("Libelle test", 5600F, "Client Test67");
		entityManger.persist(factureTest);
		entityManger.flush();
		
		//  Act  (agir) 
		Facture  foundFacture = factureRepository.getFactureByLibelle(factureTest.getLibelle());
		
		//	Assert (vérifier)
	}

}
