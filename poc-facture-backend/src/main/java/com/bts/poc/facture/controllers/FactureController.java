package com.bts.poc.facture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
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

@CrossOrigin("*")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/invoices")

public class FactureController implements IFactureController {

	@Autowired
	IFactureService factureService;
	
	@Override
	@PostMapping("/create")
	//@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Facture saveFacture(@RequestBody Facture facture) {
		
		return factureService.saveFacture(facture);
	}

	@Override
	@PutMapping("/update")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public Facture updateFacture(@RequestBody Facture facture) {
		return factureService.updateFacture(facture);
	}

	@Override
	@GetMapping("/invoice/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public Facture getFacture(@PathVariable Long id) {
		
		return factureService.getFacture(id);
	}

	@Override
	@GetMapping("/invoices")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> getAllFacture() {
		
		return factureService.getAllFacture();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public void deleteFacture(@PathVariable Long id) {
		factureService.deleteFacture(id);
	}

	@Override
	@DeleteMapping("/delete/allInvoices")
	@PreAuthorize("hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public void deleteAllFacture() {
		factureService.deleteAllFacture();

	}

	@Override
	@GetMapping("/keyword")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

	//@CrossOrigin(origins = "http://localhost:4200")
	public List<Facture> findFactureByCustomerRef(@RequestParam ("mc")  String customerRef) {		
		return factureService.findFactureByCustomerRef(customerRef);
	}

	@Override	
	@GetMapping("/all")	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	
	//@CrossOrigin(origins = "http://localhost:4200")
	public Page<Facture> findFactureList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findAllPages(paging);
	}

	@Override
	@GetMapping("/invoicesByPage")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

	//@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Facture> findFactureByPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findFactureByPage(paging);
	}
	
	@Override
	@GetMapping("/KeywordByPage")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	//@CrossOrigin(origins = "http://localhost:4200")
	public Page<Facture> findFactureByCustomerRef(@RequestParam ("mc")  String customerRef, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		return factureService.findFactureByCustomerRef(customerRef, paging);
	}
	
	

}
