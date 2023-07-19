package com.bts.poc.facture.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("facture")
public class Facture {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private Long id;
	
	private String libelle;
	
	public Float montant;
	
	private String client;
	
	

	public Facture() {
		super();
	}

	
	public Facture(String libelle, Float montant, String client) {
		super();
		
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
	
	

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	@Override
	public String toString() {
		return "facture [id=" + id + ", libelle=" + libelle + ", montant=" + montant + ", client=" + client + "]";
	}
	
	
	
	

}
