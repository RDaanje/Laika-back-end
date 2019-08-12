package nl.YoungCapital.Laika.api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.domain.Cart;
import nl.YoungCapital.Laika.domain.Orderhistory;
import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.domain.Wallet;
import nl.YoungCapital.Laika.service.AccountService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/account", produces = MediaType.APPLICATION_JSON_VALUE)

public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(path = "playgame")
	public void playGame() {
		
	}

	@GetMapping(path = "get/{username}/{password}")
	public ResponseEntity<Account> findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password")String password) {
		System.out.println("in username/password methode");
		Optional<Account> accountCheck = accountService.findByUsernameAndPassword(username, password);
		System.out.println(accountCheck);
		if (!accountCheck.isPresent() )	{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else { 
			Account accountOk = accountCheck.get();
			return new ResponseEntity<Account>(accountOk, HttpStatus.OK);			
		}
	}
	
	@GetMapping(path = "get")
	public Iterable<Account> findAll() {
 
		return accountService.findAll();
	}

	@GetMapping(path= "{id}")
	public Optional<Account> findById(@PathVariable Long id) {
		System.out.println("in id methode");
		return accountService.findById(id);
	}
	
	@GetMapping(path = "/forgot/{email}")
	public ResponseEntity<Account> findByEmail(@PathVariable String email)	{
		System.out.println(email);
		Optional<Account> accountCheck = accountService.findByEmail(email);
		if (!accountCheck.isPresent()) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
			
		} else {
			Account accountOk = accountCheck.get();
			return new ResponseEntity<Account>(accountOk, HttpStatus.OK);
		}
	}

	@PostMapping(path = "create")
	public ResponseEntity<Account> create(@RequestBody Account input) {

		Optional<Account> accountCheck = accountService.findByUsername(input.getUsername());
		Optional<Account> accountCheck2 = accountService.findByEmail(input.getEmail());
		
		if (accountCheck.isPresent()) {
			return new ResponseEntity<Account>(HttpStatus.CONFLICT);
		} else if (accountCheck2.isPresent()){ 
			return new ResponseEntity<Account>(HttpStatus.FOUND);
		} else {
			Wallet walletNew = new Wallet();
			Cart cartNew = new Cart();
			
			input.setWallet(walletNew);
			input.setCart(cartNew);
			Orderhistory orderhistoryNew = new Orderhistory();
			input.setOrderhistory(orderhistoryNew);
			
			return new ResponseEntity<Account>(accountService.save(input), HttpStatus.OK);
		}
					
	}
	

	@PutMapping(path = "{id}/{email}")
	public Optional<Account> changeEmail(@PathVariable("id") long id, @PathVariable("email") String email){
		accountService.findById(id).get().setEmail(email);
		return accountService.findById(id);
	}

	@PutMapping(path = "{id}/wallet/{money}")
	public ResponseEntity<Account> addMoney(@PathVariable("id") long id, @PathVariable("money") double money)	{
		
		Optional<Account> accountcheck = accountService.findById(id);
		
		Account accountOk = accountcheck.get();
		accountOk.getWallet().setEuro(money);
		
			return new ResponseEntity<Account>(accountService.save(accountOk), HttpStatus.OK);
			
		}
	
	@PutMapping(path= "{id}/update")
	public Account accountUpdate(@PathVariable long id, @RequestBody Account account) {
		Optional<Account> accountCheck = accountService.findById(account.getId());
		
		accountCheck.get().setFirstname(account.getFirstname());	//overbodig met ngmodel
		accountCheck.get().setLastname(account.getLastname());		//overbodig met ngmodel
		
		
		return accountService.save(account);
	} 

	
	@PutMapping(path = "{id}/cart")
	public ResponseEntity<Account> addProductToCart(@PathVariable long id, @RequestBody Product product)	{
		Optional<Account> accountcheck = accountService.findById(id);
		
		Account accountOk = accountcheck.get();

		System.out.println(accountOk.getCart());
		System.out.println(accountOk.getCart().getId());
		accountOk.getCart().setProductInCart(product.getId());

		
			return new ResponseEntity<Account>(accountService.save(accountOk), HttpStatus.OK);	
		}
	
	@DeleteMapping(path = "{id}/delete")
	public ResponseEntity<Account> deleteAccount(@PathVariable long id)	{
		if (!accountService.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		} else {
			accountService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	} 
	

//	@GetMapping(path= "{id}/cart")
//	public Iterable<ArrayList<Long>> returnCart(@PathVariable Long id) {
//		System.out.println("in id /cart");
//		Iterable<Account> accountcheck = accountService.findById(id);
//		Account accountOk = accountcheck.get();
//		return accountOk.getCart().getProductsFromCart();
//	}
	
//	@GetMapping(path = "get")
//	public ArrayList<Long> findAll2() {
//
//		return accountService.findById(1l).get().getCart().getProductsFromCart();
//	}
//
//	
	}
	
