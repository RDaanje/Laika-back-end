package nl.YoungCapital.Laika.domain;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 10000)		
	private ArrayList<Long> productsInCart = new ArrayList<>();


	// no-args Constructor
	public Cart() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public ArrayList<Long> getProductsFromCart() {
		return productsInCart;

	}
	
//	public Long getLongsFromCart() {
//		for(Long product: productsInCart) {
//			return product;
//		}
//	}


	public void setProductInCart(Long productInCart) {
		productsInCart.add(productInCart);

	}
	
}