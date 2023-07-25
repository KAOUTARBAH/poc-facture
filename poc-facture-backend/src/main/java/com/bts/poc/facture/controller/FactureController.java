package com.bts.poc.facture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.service.IFactureService;

@RestController
public class FactureController implements IFactureController {

	@Autowired
	IFactureService factureService;
	
	@Override
	@PostMapping("/facture")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture saveFacture(@RequestBody Facture facture) {
		
		return factureService.saveFacture(facture);
	}

	@Override
	@PutMapping("/facture")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture updateFacture(@RequestBody Facture facture) {
		return factureService.updateFacture(facture);
	}

	@Override
	@GetMapping("/facture/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture getFacture(@PathVariable Long id) {
		
		return factureService.getFacture(id);
	}

	@Override
	@GetMapping("/facture/allFacture")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> getAllFacture() {
		
		return factureService.getAllFacture();
	}

	@Override
	@DeleteMapping("/facture/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteFacture(@PathVariable Long id) {
		factureService.deleteFacture(id);
	}

	@Override
	@DeleteMapping("/facture/allfacture")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllFacture() {
		factureService.deleteAllFacture();

	}

	@Override
	@GetMapping("/facture/libelle")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> findFactureByLibelle(@RequestParam ("mc")  String libelle) {		
		return factureService.findFactureByLibelle(libelle);
	}
	
	

}
