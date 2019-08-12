package nl.YoungCapital.Laika.domain;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
public class Wallet {
@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(length = 4000000)
	private long id;
	
	private double euro;
	private double coins;
		
	
	//no-args Constructor
	public Wallet()	{
		
	}
	public Wallet(double euro, double coins) {
		this.euro = euro;
		this.coins = coins;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getEuro() {
		return euro;
	}
	public void setEuro(double euro) {
		this.euro += euro;
	}
	public double getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
}
