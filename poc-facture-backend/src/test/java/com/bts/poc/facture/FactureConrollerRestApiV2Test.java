package com.bts.poc.facture;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bts.poc.facture.model.Facture;


//Using TestRestTemplate and @SpringBootTest


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FactureConrollerRestApiV2Test {

	
//TestRestTemplate is an HTTP client that provides a convenient and concise way to test restful web services.	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int randomServerPort;
	
	
	@Test
    void factureList() {
        Facture[] factures = restTemplate.getForObject("http://localhost:" + randomServerPort + "/api/v1/invoices/invoices", Facture[].class);
        
        assertEquals(8, factures.length);
        assertEquals("Facture test", factures[0].getLibelle());
    }
	
	@Test
    void getFactureById() {
        Facture facture = restTemplate.getForObject("http://localhost:" + randomServerPort + "/api/v1/invoices/invoice/4", Facture.class);
        
        assertEquals(4, facture.getId());
        assertEquals("PC PORTABLE", facture.getLibelle());
        assertEquals("STOCKOMANI", facture.getClient());
        assertEquals(569, facture.getMontant());
    }
	
	
	  @Test
      void add_new_facture() throws Exception {
          Facture newFacture = new Facture();
          newFacture.setLibelle("Adrien");
          newFacture.setClient("Miller");
          newFacture.setMontant(900F);
          ResponseEntity response = restTemplate.postForEntity("http://localhost:" + randomServerPort + "/api/v1/invoices/create", newFacture, Facture.class);

          assertEquals(200, response.getStatusCodeValue());
          assertEquals("Adrien", ((Facture) response.getBody())
              .getLibelle());
          assertEquals("Miller", ((Facture) response.getBody())
              .getClient());
          assertEquals(900, ((Facture) response.getBody())
                  .getMontant());
      }
	  
	  @Test
      void updateFacture() throws Exception {
		  Facture updatedFacture = new Facture();
		  updatedFacture.setId(2L);
		  updatedFacture.setLibelle("Machaine A CAFE_UPDATE");
		  updatedFacture.setClient("CARFFEUR_UPFATE");
		  updatedFacture.setMontant(900F);
          HttpEntity requestUpdate = new HttpEntity<>(updatedFacture);
          ResponseEntity response = restTemplate.exchange("http://localhost:" + randomServerPort + "/api/v1/invoices/update", HttpMethod.PUT, requestUpdate, Facture.class);

          assertEquals("Machaine A CAFE_UPDATE", ((Facture) response.getBody())
              .getLibelle());
      }

      @Test
      void removeFacture() throws Exception {
    	  
          restTemplate.delete("http://localhost:" + randomServerPort + "/api/v1/invoices/delete/12");
          Facture facture = restTemplate.getForObject("http://localhost:" + randomServerPort + "/api/v1/invoices/delete/12", Facture.class);
          assertNull(facture.getId());
       
      }

}
