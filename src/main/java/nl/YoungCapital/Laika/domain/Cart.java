package nl.YoungCapital.Laika.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private ArrayList<Product> productsInCart = new ArrayList<>();

	// no-args Constructor
	public Cart() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Product> getProductsFromCart() {
		return productsInCart;
	}

	public void setProductInCart(Product productInCart) {
		productsInCart.add(productInCart);
	}
	
}