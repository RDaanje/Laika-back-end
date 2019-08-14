package nl.YoungCapital.Laika.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    
	
	private String date;
    private String status;
    private String name;
    private String adress;
    private String zipcode;
    private String email;
    private String counter;
    private String total;
    
    
    public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@OneToMany(cascade = {CascadeType.ALL})	
    private Set<orderProduct> orderSubSet = new HashSet<>();



	public long getId() {
		return id;
    }
    
	public void setId(long id) {
		this.id = id;
	}
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress; 
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}

	public Set<orderProduct> getOrderSubSet() {
		if(this.orderSubSet == null)
			this.setOrderSubSet(new HashSet());
		
		return orderSubSet;
	}

	public void setOrderSubSet(Set<orderProduct> orderSubSet) {
		if(this.orderSubSet == null)
			this.setOrderSubSet(new HashSet());
		
		this.orderSubSet = orderSubSet;
	}


}
