package com.bts.poc.facture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.poc.facture.model.Facture;
import com.bts.poc.facture.service.IFactureService;

@RestController
@RequestMapping("/api/v1/invoices")


public class FactureController implements IFactureController {

	@Autowired
	IFactureService factureService;
	
	@Override
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture saveFacture(@RequestBody Facture facture) {
		
		return factureService.saveFacture(facture);
	}

	@Override
	@PutMapping("/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture updateFacture(@RequestBody Facture facture) {
		return factureService.updateFacture(facture);
	}

	@Override
	@GetMapping("/invoice/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Facture getFacture(@PathVariable Long id) {
		
		return factureService.getFacture(id);
	}

	@Override
	@GetMapping("/invoices")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> getAllFacture() {
		
		return factureService.getAllFacture();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteFacture(@PathVariable Long id) {
		factureService.deleteFacture(id);
	}

	@Override
	@DeleteMapping("/delete/allInvoices")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllFacture() {
		factureService.deleteAllFacture();

	}

	@Override
	@GetMapping("/keyword")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> findFactureByLibelle(@RequestParam ("mc")  String libelle) {		
		return factureService.findFactureByLibelle(libelle);
	}

	@Override
	@GetMapping("")
	@CrossOrigin(origins = "http://localhost:4200")
	public Page<Facture> findFactureList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findAllPages(paging);
	}

	@Override
	@GetMapping("/invoicesByPage")
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Facture> findFactureByPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findFactureByPage(paging);
	}
	
	@Override
	@GetMapping("/KeywordByPage")
	@CrossOrigin(origins = "http://localhost:4200")
	public Page<Facture> findFactureByLibelle(@RequestParam ("mc")  String libelle, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findFactureByLibelle(libelle, paging);
	}
	
	

}
