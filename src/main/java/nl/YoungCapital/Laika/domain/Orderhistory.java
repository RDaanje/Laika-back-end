package nl.YoungCapital.Laika.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orderhistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(length = 429496729)
	@JsonFormat(shape=JsonFormat.Shape.ARRAY)
	private ArrayList<Cart> allOrders = new ArrayList<>();

	private String productName;
	private boolean paid;
	private double totalCosts;
	private LocalDateTime time;
	
	public Orderhistory() {
	}
	public Orderhistory(LocalDateTime time) {
		this.time = time;
	}
	public Orderhistory( String productName, boolean paid, double totalCosts) {
		this.productName = productName;
		this.paid = paid;
		this.totalCosts = totalCosts;
	}
	
	public Orderhistory( LocalDateTime time, String productName, boolean paid, double totalCosts) {
		this.time = time;
		this.productName = productName;
		this.paid = paid;
		this.totalCosts = totalCosts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public double getTotalCosts() {
		return totalCosts;
	}

	public void setTotalCosts(double totalCosts) {
		this.totalCosts = totalCosts;
	}

	public ArrayList<Cart> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(Cart cart) {
		allOrders.add(cart);
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;;
	}

}
