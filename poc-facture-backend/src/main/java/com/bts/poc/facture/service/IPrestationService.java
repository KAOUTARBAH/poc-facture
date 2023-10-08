package com.bts.poc.facture.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.model.Prestation;



public interface IPrestationService {
	
	Prestation save(Prestation prestation); 
//	Facture updateFacture(Facture facture); 
//	Facture getFacture(Long id); 
//	List<Facture> getAllFacture(); 
//	List<Facture> findFactureByLibelle(String libelle); 
//	Page<Facture> findFactureByLibelle(String libelle,Pageable pageable); 
//	void deleteFacture(Long id); 
//	void deleteAllFacture(); 
//	Page<Facture> findAllPages(Pageable pageable);
//	public Iterable<Facture> findFactureByPage(Pageable pageable);
	
	

}
