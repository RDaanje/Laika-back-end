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


@Entity
public class Cart	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

//	@Column(length = 10000)		
//	private ArrayList<Long> productsInCart = new ArrayList<>();
//	
//	@Column(length = 500)
//	private ArrayList<Long> productstoShow = new ArrayList<>();
//	
//	@Column(length = 500)
//	private ArrayList<Integer> productstoShowAmmount = new ArrayList<>();
	
	private double total;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Account account;
	
	@OneToMany
	public Set<Product> productSet;
	
	private int totalProducts;
	

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




//	public ArrayList<Integer> getProductstoShowAmmount() {
//		return productstoShowAmmount;
//	}
//
//	public void setProductstoShowAmmount(ArrayList<Integer> productstoShowAmmount) {
//		this.productstoShowAmmount = productstoShowAmmount;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



//	public ArrayList<Long> getProductsFromCart() {
//		return productsInCart;
//
//	}
//
//
//	public void setProductInCart(Long productInCart) {
//		productsInCart.add(productInCart);
//		if(!(productstoShow.contains(productInCart))) {
//			productstoShow.add(productInCart);
//			productstoShowAmmount.add(productstoShow.lastIndexOf(productInCart), 1);
//		}else {
//			productstoShowAmmount.set(productstoShow.indexOf(productInCart), (productstoShowAmmount.get(productstoShow.indexOf(productInCart))+1));
//		}
//
//	}
	
	
	
	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Product productSet) {
		this.productSet.add(productSet);
	}
	
	public void removeProductSet(Product productSet) {
		this.productSet.remove(productSet);
	}

//	public void deleteProductFromCart(Long productInCart) {
//		productsInCart.remove(productInCart);
//		productstoShowAmmount.set(productstoShow.indexOf(productInCart), (productstoShowAmmount.get(productstoShow.indexOf(productInCart))-1));
//		if(!(productsInCart.contains(productInCart))) {
//			productstoShowAmmount.remove(productstoShowAmmount.get(productstoShow.indexOf(productInCart)));
//			productstoShow.remove(productInCart);
//	}
//	}
//
//	public ArrayList<Long> getProductstoShow() {
//		return productstoShow;
//	}
//
//	public void setProductstoShow(ArrayList<Long> productstoShow) {
//		this.productstoShow = productstoShow;
//	}

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