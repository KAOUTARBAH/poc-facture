package com.bts.poc.facture.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bts.poc.facture.model.Facture;

public interface IFactureController {
	
	Facture saveFacture(Facture facture); 
	Facture updateFacture(Facture facture); 
	Facture getFacture(Long id); 
	List<Facture> getAllFacture(); 
	List<Facture> findFactureByLibelle(String libelle);
	void deleteFacture(Long id); 
	void deleteAllFacture(); 

}
