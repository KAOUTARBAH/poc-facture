package com.bts.poc.facture.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	Page<Facture> findFactureList(Integer page, Integer size);
	Iterable<Facture> findFactureByPage(Integer page, Integer size);

}
