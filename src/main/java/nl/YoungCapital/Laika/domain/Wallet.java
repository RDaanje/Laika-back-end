package nl.YoungCapital.Laika.domain;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public void setCoins(double coins) {
		this.coins += coins;
	}
}
