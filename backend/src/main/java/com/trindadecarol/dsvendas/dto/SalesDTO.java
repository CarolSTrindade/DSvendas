package com.trindadecarol.dsvendas.dto;

import java.time.LocalDate;

import com.trindadecarol.dsvendas.entities.Sales;

public class SalesDTO {

	
	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	private SellerDTO seller;
	
	public SalesDTO() {};
	
	public SalesDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		super();
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	
	public SalesDTO(Sales entity) {
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		seller = new SellerDTO(entity.getSeller());
	}
	
	
	
	
}
