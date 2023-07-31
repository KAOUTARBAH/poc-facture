package com.bts.poc.facture.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bts.poc.facture.model.Facture;



public interface IFactureService {
	
	Facture saveFacture(Facture facture); 
	Facture updateFacture(Facture facture); 
	Facture getFacture(Long id); 
	List<Facture> getAllFacture(); 
	List<Facture> findFactureByLibelle(String libelle); 
	Page<Facture> findFactureByLibelle(String libelleabl,Pageable pageable); 
	void deleteFacture(Long id); 
	void deleteAllFacture(); 
	Page<Facture> findAllPages(Pageable pageable);
	public Iterable<Facture> findFactureByPage(Pageable pageable);
	

}
