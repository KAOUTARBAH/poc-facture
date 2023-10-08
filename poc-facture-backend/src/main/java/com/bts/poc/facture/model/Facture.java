package com.bts.poc.facture.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("facture")
public class Facture {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	// invoiceNum
	@Id
	private Long id;

	//private String libelle;

	private String customerRef;
	// (email)
	private String customerContact;

	private Date dueDate;
	private Date emissionDate;

	//private List<Prestation> prestations = new ArrayList<Prestation>();
	private Prestation prestation;

	public Facture() {
		super();
	}

	public Facture( String customerRef, String customerContact, Date dueDate,
			Date emissionDate) {
		super();
		//this.libelle = libelle;
		this.customerRef = customerRef;
		this.customerContact = customerContact;
		this.dueDate = dueDate;
		this.emissionDate = emissionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getLibelle() {
//		return libelle;
//	}
//
//	public void setLibelle(String libelle) {
//		this.libelle = libelle;
//	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", customerRef=" + customerRef + ", customerContact="
				+ customerContact + ", dueDate=" + dueDate + ", emissionDate=" + emissionDate + ", prestation="
				+ prestation + "]";
	}

	

	

}
