package com.bts.poc.facture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;



import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.bts.poc.facture.controller.FactureController;
import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;
import com.bts.poc.facture.service.FactureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@WebMvcTest(FactureController.class)
class FactureConrollerRestApiTest {

	//@WebMvcTest lets us specify the controller we want to test.
	@MockBean
	private FactureService factureServive;
	
	//@MockBean to create a mock of EmployeeService
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private IFactureRepository factureRepository; 
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Test
	void getAllFacture() throws Exception{
		Facture facture = this.buildTestingFacture();
		when(factureServive.getAllFacture()).thenReturn(List.of(facture));
		
	mockMvc.perform(get("/api/v1/invoices/invoices"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].id", is(1)))
		.andExpect(jsonPath("$[0].libelle", is("FIRST_NAME")))
		.andExpect(jsonPath("$[0].client", is("LAST_NAME")))
		.andExpect(jsonPath("$[0].montant", is(3000.0)));
		
	}
	
	@Test
	void getFactureById() throws Exception{
		Facture facture = this.buildTestingFacture();
		when(factureServive.getFacture(1L)).thenReturn(facture);
		
	mockMvc.perform(get("/api/v1/invoices/invoice/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.libelle", is("FIRST_NAME")))
		.andExpect(jsonPath("$.client", is("LAST_NAME")))
		.andExpect(jsonPath("$.montant", is(3000.0)));
		
	}
	
	@Test
	void saveFacture() throws Exception{
		Facture facture = this.buildTestingFacture();
		when(factureServive.saveFacture(facture)).thenReturn(facture);
		
		//when(factureRepository.save(facture)).thenReturn(facture);
		String content = objectWriter.writeValueAsString(facture);
		
		mockMvc.perform(post("/api/v1/invoices/create")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(content))
			//.content("{\"libelle\": \"FIRST_NAME\", \"client\": \"LAST_NAME\" }"))
			.andExpect(status().isOk())
//		    .andExpect(jsonPath("$.libelle", is(facture.getLibelle())))
//		    .andExpect(jsonPath("$.client", is(facture.getClient())))
			.andDo(print());
		//.content(content))
//			.andExpect(status().isOk())
//			//.andExpect(jsonPath("$.id", is("id")))
//			//.andExpect(jsonPath("$", notNullValue()))
//		    .andExpect(jsonPath("$.libelle", is("FIRST_NAME")))
//		    .andExpect(jsonPath("$.client", is("LAST_NAME")));
		
//		ResultActions response= mockMvc.perform(post("/api/v1/invoices/create")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(content));
//		
//		response.andDo(print())
//		//.andExpect(status().isCreated())
//		.andExpect(status().isOk())
//		//.andExpect(jsonPath("$.id", is("id")))
//		//.andExpect(jsonPath("$", notNullValue()))
//	    .andExpect(jsonPath("$.libelle", is(facture.getLibelle())))
//	    .andExpect(jsonPath("$.client", is(facture.getClient())));
//	   // .andExpect(jsonPath("$.client", is(facture.getClient())));
//
//		
				//.content("{\"libelle\": \"FIRST_NAME\", \"client\": \"LAST_NAME\" }"));
				//.content(content))
			
	}
	
	@Test
    void updateFacture() throws Exception {
		Facture facture = this.buildTestingFacture();
        when(factureServive.updateFacture(facture)).thenReturn(facture);

        mockMvc.perform(put("/api/v1/invoices/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"id\": 1 , \"libelle\": \"FIRST_NAME\", \"client\": \"LAST_NAME\" }"))
            .andExpect(status().isOk());
           // .andExpect(jsonPath("$.libelle", is("FIRST_NAME_Update")));
    }
	
	  @Test
      void remove_facture() throws Exception {
          mockMvc.perform(delete("/api/v1/invoices/delete/2"))
              .andExpect(status().isOk());
      }
	
	 private Facture buildTestingFacture() {
		 Facture facture = new Facture();		 
		 facture.setId(1L);
		 facture.setLibelle("FIRST_NAME");
		 facture.setClient("LAST_NAME");
		 facture.setMontant(3000F);
		
       return facture;
     }

}
