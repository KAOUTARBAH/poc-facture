package com.bts.poc.facture.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("facture")
public class Facture {
	
	@Id
	
	private Long id;
	
	private String libelle;
	
	public Float montant;
	
	private String client;

	public Facture() {
		super();
	}

	
	public Facture(Long id, String libelle, Float montant, String client) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.montant = montant;
		this.client = client;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "facture [id=" + id + ", libelle=" + libelle + ", montant=" + montant + ", client=" + client + "]";
	}
	
	
	
	

}
