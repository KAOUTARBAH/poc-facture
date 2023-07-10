package com.bts.poc.facture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.repository.IFactureRepository;

@Service
public class FactureService implements IFactureService {
	
	@Autowired
	IFactureRepository factureRepository;

	@Override
	public Facture saveFacture(Facture facture) {
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

}
