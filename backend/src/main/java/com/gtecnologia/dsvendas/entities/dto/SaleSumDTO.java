package com.gtecnologia.dsvendas.entities.dto;

import java.io.Serializable;

import com.gtecnologia.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sallerName;
	private Double sum;

	public SaleSumDTO() {

	}

	public SaleSumDTO(Seller saller, Double sum) {
		this.sallerName = saller.getName();
		this.sum = sum;
	}

	public String getSallerName() {
		return sallerName;
	}

	public void setSallerName(String sallerName) {
		this.sallerName = sallerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}
