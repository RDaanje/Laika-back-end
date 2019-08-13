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
public class Orderhistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(cascade = {CascadeType.ALL})	
	private Set<Orders> orderSet = new HashSet<>();

	public long getId() {
		return id;
	}

	public Set<Orders> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}

	public void setId(long id) {
		this.id = id;
	}


	
}
