package com.bts.poc.facture.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.AllArgsConstructor;
//import lombok.Data;

@Document("prestation")
//@Data
//@AllArgsConstructor
public class Prestation {

//	@Id
//	private long id;
	private String description;
	private Integer quantity;
	private Float unitPrice;
	private String unit;
	private Float vATRate;
	private Date prestationDate;

	public Prestation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestation(String description, Integer quantity, Float unitPrice, String unit, Float vATRate,
			Date prestationDate) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.vATRate = vATRate;
		this.prestationDate = prestationDate;
	}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getvATRate() {
		return vATRate;
	}

	public void setvATRate(Float vATRate) {
		this.vATRate = vATRate;
	}

	public Date getPrestationDate() {
		return prestationDate;
	}

	public void setPrestationDate(Date prestationDate) {
		this.prestationDate = prestationDate;
	}

	@Override
	public String toString() {
		return "Prestation [description=" + description + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", unit=" + unit + ", vATRate=" + vATRate + ", prestationDate=" + prestationDate + "]";
	}

}
