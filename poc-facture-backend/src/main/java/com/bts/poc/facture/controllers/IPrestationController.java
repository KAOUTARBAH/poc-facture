package com.bts.poc.facture.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.model.Prestation;

public interface IPrestationController {
	
	Prestation save(Prestation prestation); 
//	Facture updateFacture(Facture facture); 
//	Facture getFacture(Long id); 
//	List<Facture> getAllFacture(); 
//	List<Facture> findFactureByLibelle(String libelle);
//	Page<Facture>findFactureByLibelle(String libelle,Integer page, Integer size);
//	void deleteFacture(Long id); 
//	void deleteAllFacture(); 
//	Page<Facture> findFactureList(Integer page, Integer size);
//	Iterable<Facture> findFactureByPage(Integer page, Integer size);

}
