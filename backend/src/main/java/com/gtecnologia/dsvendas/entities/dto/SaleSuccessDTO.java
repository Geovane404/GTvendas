package com.gtecnologia.dsvendas.entities.dto;

import java.io.Serializable;

import com.gtecnologia.dsvendas.entities.Seller;

public class SaleSuccessDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sallerName;
	private Long visited;
	private Long deals;

	public SaleSuccessDTO() {

	}

	public SaleSuccessDTO(Seller saller, Long visited, Long deals) {
		this.sallerName = saller.getName();
		this.visited = visited;
		this.deals = deals;
	}

	public String getSallerName() {
		return sallerName;
	}

	public void setSallerName(String sallerName) {
		this.sallerName = sallerName;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}

}
