package de.ostfalia.swt.aufgabe6;

import java.math.BigDecimal;

public class Product {

	private Integer id;
	private String description;
	private BigDecimal price;
	
	
	public Product() {
	}


	public Product(Integer id, String description, BigDecimal price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

	

}