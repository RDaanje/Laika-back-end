package nl.YoungCapital.Laika.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 	
	private String name;
	private String supplier;
	private long stock;
	private double price;
	private String image;
	private int quantity =1;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Cart cart;
	
	public Product() {}
	
	public Product (String name, String supplier, long stock, double price, String image) {
		this.name = name;
		this.supplier = supplier;
		this.stock = stock;
		this.price = price;
		this.image = image;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product p = (Product) obj;
		return p.getId() == this.getId();
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
	

	
}
