package com.bts.poc.facture.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;

@Service
public class FactureService implements IFactureService {
	
	@Autowired
	IFactureRepository factureRepository;
	

	@Autowired
	sequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public Facture saveFacture( @RequestBody Facture facture) {
		facture.setId(sequenceGeneratorService.generateSequence(facture.SEQUENCE_NAME));
		return factureRepository.save(facture);
	}

	@Override
	public Facture updateFacture(Facture facture) {
		return factureRepository.save(facture);
	}

	@Override
	public Facture getFacture(Long id) {
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	public List<Facture> getAllFacture() {
		return factureRepository.findAll();
	}
	
	
	

	@Override
	public void deleteFacture(Long id) {
		factureRepository.deleteById(id);

	}

	@Override
	public void deleteAllFacture() {
		factureRepository.deleteAll();

	}

	@Override
	public List<Facture> findFactureByCustomerRef(String customerRef){	
		//return factureRepository.findFactureByLibelle(libelle);
		List<Facture> factures = new ArrayList<>();
		Query searchQuery = new Query();
		//le mot le recherche cest le libelle 
		//searchQuery.addCriteria(Criteria.where("libelle").is(libelle));
		//le mot cle rechrche commance par tes*
		//searchQuery.addCriteria(Criteria.where("libelle").regex("^TEST"));
		searchQuery.addCriteria(Criteria.where("customerRef").regex(customerRef));
		factures = mongoOperations.find(searchQuery, Facture.class);
		
		return factures;
		
	}

	@Override
	public Page<Facture> findAllPages(Pageable pageable) {	
		return factureRepository.findAll(pageable);
	}

	@Override
	
	public Page<Facture> findFactureByCustomerRef(String customerRef, Pageable pageabl) {		
		
		List<Facture> factures = new ArrayList<>();
		Query searchQuery = new Query();
		
		searchQuery.addCriteria(Criteria.where("customerRef").regex(customerRef))
		.with(pageabl);
		
		factures = mongoOperations.find(searchQuery.with(pageabl), Facture.class);
		Page<Facture> facturesWithPage= new PageImpl<Facture>(factures, pageabl, factures.size());
		return facturesWithPage;
		 
	}

	
	@Override
	public Iterable<Facture> findFactureByPage(Pageable pageable) {
		
		return factureRepository.findAll(pageable);
	}



}
