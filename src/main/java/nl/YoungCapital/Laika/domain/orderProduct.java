package nl.YoungCapital.Laika.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class orderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	 private String productname;
	 private String productprice;
	 private String productquantity;
	 private String producttotal;
	 
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public String getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}
	public String getProducttotal() {
		return producttotal;
	}
	public void setProducttotal(String producttotal) {
		this.producttotal = producttotal;
	}

}
