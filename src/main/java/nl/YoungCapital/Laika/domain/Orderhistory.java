package nl.YoungCapital.Laika.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orderhistory {
@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(length = 4000000)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Account account;
	
	
	private String productName;
	private boolean paid;
	private double totalPerCart;
	private LocalDateTime time;
	
	
	public Orderhistory() {
	}
	public Orderhistory(LocalDateTime time) {
		this.time = time;
	}
	public Orderhistory( String productName, boolean paid, double totalPerCart) {
		this.productName = productName;
		this.paid = paid;
		this.totalPerCart = totalPerCart;
	}
	
	public Orderhistory( LocalDateTime time, String productName, boolean paid, double totalPerCart) {
		this.time = time;
		this.productName = productName;
		this.paid = paid;
		this.totalPerCart = totalPerCart;
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

	public double getTotalPerCart() {
		return totalPerCart;
	}

	public void setTotalPerCart(double totalPerCart) {
		this.totalPerCart = totalPerCart;
	}

	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;;
	}

}
