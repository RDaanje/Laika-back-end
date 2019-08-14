package nl.YoungCapital.Laika.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Cart	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private double total;
	private double totalCoins;
	



	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn	
	private Account account;
	
	@ManyToMany(cascade = CascadeType.ALL)
	public Set<Product> productSet = new HashSet<Product>();
	
	private int totalProducts = 0;
	
	@ManyToOne(cascade = {CascadeType.ALL})
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

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
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
		this.totalCoins = 0;
		for(Product p: productSet) {
			this.total = this.total + (p.getPrice()*(p.getQuantity()));
			this.totalCoins = this.totalCoins + (p.getPriceCoins()*p.getQuantity());
		}
	}
	
	public double getTotalCoins() {
		return totalCoins;
	}

	public void setTotalCoins(double totalCoins) {
		this.totalCoins = totalCoins;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Orderhistory getOrderhistory() {
		return orderhistory;
	}

	public void setOrderhistory(Orderhistory orderhistory) {
		this.orderhistory = orderhistory;
	}
	   
//	public void minTotal(double total) {
//		if(this.total-total<=0.5) {this.total = 0;}
//		else {
//		this.total = this.total-total;
//		}
//	}

	
}