package nl.YoungCapital.Laika.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 	
	

	private String name;
	private String supplier;
	private long stock;
	private double price;
	private double priceCoins;
	private String image;
	private String description;
	private int quantity = 1;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn
	@JsonIgnoreProperties(value= {"productSet"}, allowSetters = true)
	private Cart cart;


	public Product() {}
	


	public Product (
			String name, String supplier, long stock, double price, double priceCoins, String image, String description) {
		
		this.name = name;
		this.supplier = supplier;
		this.stock = stock;
		this.price = price;
		this.priceCoins = priceCoins;
		this.image = image;
		this.description = description; 
	}
	
	@Override
	public boolean equals(Object obj) {
		Product p = (Product) obj;
		return p.getName() == this.getName();
	}
	
	public double getPriceCoins() {
		return priceCoins;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setPriceCoins(double priceCoins) {
		this.priceCoins = priceCoins;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	
}
