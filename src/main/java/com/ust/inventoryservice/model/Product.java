package com.ust.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	private String name;
	@Id
	private String code;
	private int price;
	private String quality;
	private int quantity;
	private String description;

	public Product() {
		super();
	}

	public Product(String name, String code, int price, String quality, int quantity, String description) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.quality = quality;
		this.quantity = quantity;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", price=" + price + ", quality=" + quality + ", quantity="
				+ quantity + ", description=" + description + "]";
	}

}