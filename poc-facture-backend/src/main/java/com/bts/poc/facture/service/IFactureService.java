package com.bts.poc.facture.service;

import java.util.List;

import com.bts.poc.facture.model.Facture;



public interface IFactureService {
	
	Facture saveFacture(Facture facture); 
	Facture updateFacture(Facture facture); 
	Facture getFacture(Long id); 
	List<Facture> getAllFacture(); 
	void deleteFacture(Long id); 
	void deleteAllFacture(); 

}
