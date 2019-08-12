package nl.YoungCapital.Laika.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Account {
	@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(length = 429496729)
	private long id;
	
	private String firstname;
	private String lastname;
	
	private String username;
	private String password;
	private String email;
	
	private String street;
	private String houseNumber;
	private String zipcode;
	private String city;
	
	private boolean isAdmin;
	
	

	@OneToOne(cascade = {CascadeType.ALL})				
	private Wallet wallet;
	
	@OneToOne(cascade = {CascadeType.ALL})				
	private Cart cart;
	
	@OneToOne(cascade = {CascadeType.PERSIST})				
	private Orderhistory orderhistory;
	
//	@ManyToOne
//	private Adress adress;
	
	public Account(String firstname, 
			String lastname, 
			String username, 
			String password, 
			String email, 
			String street, 
			String houseNumber, 
			String zipcode, 
			String city,
			boolean admin) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;

		this.wallet = new Wallet();
		this.cart = new Cart();
		this.isAdmin = admin;

	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//no-args Constructor
	public Account() {
		
	}
	
	/*Getters en setters voor de fields*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public Orderhistory getOrderhistory() {
		return orderhistory;
	}

	public void setOrderhistory(Orderhistory orderhistory) {
		this.orderhistory = orderhistory;
	}

	public boolean getisAdmin() {
		return isAdmin;
	}


	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

		
}
