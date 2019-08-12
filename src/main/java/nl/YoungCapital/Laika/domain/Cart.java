package nl.YoungCapital.Laika.domain;


import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Cart	{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private long id;

	private double total;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Account account;
	
	@OneToMany
	public Set<Product> productSet;
	
	private int totalProducts;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Orderhistory orderhistory;


	// no-args Constructor
	public Cart() {
	}
	
	public int getTotalProducts() {
		this.totalProducts = 0;
		for(Product p: productSet) {
			this.totalProducts = this.totalProducts + (1*(p.getQuantity()));
		}
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Product productSet) {
		this.productSet.add(productSet);
	}
	
	public void removeProductSet(Product productSet) {
		this.productSet.remove(productSet);
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = this.total+total;
	}
	

	public void setTotal2() {
		this.total = 0;
		for(Product p: productSet) {
			this.total = this.total + (p.getPrice()*(p.getQuantity()));
		}
	}
	
//	public void minTotal(double total) {
//		if(this.total-total<=0.5) {this.total = 0;}
//		else {
//		this.total = this.total-total;
//		}
//	}

	
}