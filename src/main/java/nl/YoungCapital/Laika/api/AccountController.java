package nl.YoungCapital.Laika.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
import nl.YoungCapital.Laika.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/account", produces = MediaType.APPLICATION_JSON_VALUE)

public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	ProductService productService;

	@GetMapping(path = "playgame")
	public void playGame() {

	}

	@GetMapping(path = "get/{username}/{password}")
	public ResponseEntity<Account> findByUsernameAndPassword(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		System.out.println("in username/password methode");
		Optional<Account> accountCheck = accountService.findByUsernameAndPassword(username, password);
		System.out.println(accountCheck);
		if (!accountCheck.isPresent()) {
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

	@GetMapping(path = "{id}")
	public Optional<Account> findById(@PathVariable Long id) {
		System.out.println("in id methode");
		return accountService.findById(id);
	}

	@GetMapping(path = "/forgot/{email}")
	public ResponseEntity<Account> findByEmail(@PathVariable String email) {
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
		} else if (accountCheck2.isPresent()) {
			return new ResponseEntity<Account>(HttpStatus.FOUND);
		} else {
			Wallet walletNew = new Wallet();
			Cart cartNew = new Cart();
			Orderhistory newhistory = new Orderhistory();
			
			input.setWallet(walletNew);
			input.setCart(cartNew);
			input.setOrderhistory(newhistory);

			return new ResponseEntity<Account>(accountService.save(input), HttpStatus.OK);
		}

	}

	@PutMapping(path = "{id}/{email}")
	public Optional<Account> changeEmail(@PathVariable("id") long id, @PathVariable("email") String email) {
		accountService.findById(id).get().setEmail(email);
		return accountService.findById(id);
	}

	@PutMapping(path = "{id}/wallet/{money}")
	public ResponseEntity<Account> addMoney(@PathVariable("id") long id, @PathVariable("money") double money) {

		Optional<Account> accountcheck = accountService.findById(id);

		Account accountOk = accountcheck.get();
		accountOk.getWallet().setEuro(money);

		return new ResponseEntity<Account>(accountService.save(accountOk), HttpStatus.OK);

	}

	@PutMapping(path = "{id}/update")
	public Account accountUpdate(@PathVariable long id, @RequestBody Account account) {
		Optional<Account> accountCheck = accountService.findById(account.getId());
		System.out.println(account);
	
		return accountService.save(account);
	}

	@PutMapping(path = "{id}/cart")
	public ResponseEntity<Account> addProductToCart(@PathVariable long id, @RequestBody Product product) {
		Optional<Account> accountcheck = accountService.findById(id);

		boolean foundProductInCart = false;
		Account accountOk = accountcheck.get();
		for (Product p : accountOk.getCart().productSet) {

			if (p.equals(product)) {
				foundProductInCart = true;
				p.setQuantity((p.getQuantity() + 1));
				break;
			}

		}
		
		if (!(foundProductInCart)) {
			Set<Product> temp = new HashSet();
			temp.add(product);
			accountOk.getCart().setProductSet(temp);
		}
		
		accountOk.getCart().setTotal2();
//		accountOk.getCart().setProductInCart(product.getId());

		return new ResponseEntity<Account>(accountService.save(accountOk), HttpStatus.OK);
	}

	@DeleteMapping(path = "{id}/cart/{id2}")
	public ResponseEntity<Account> removeProductFromCart(@PathVariable long id, @PathVariable long id2) {
		Optional<Account> accountcheck = accountService.findById(id);
		Optional<Product> productcheck = productService.findById(id2);

		Account accountOk = accountcheck.get();
		Product productOk = productcheck.get();
		boolean foundProductInCart = false;
		for (Product p : accountOk.getCart().productSet) {

			if (p.equals(productOk)) {
				foundProductInCart = true;
				p.setQuantity((p.getQuantity() - 1));
				accountOk.getCart().setTotal2();
				if(p.getQuantity()==0) {
					accountOk.getCart().removeProductSet(p);
					accountOk.getCart().setTotal2();
					p.setQuantity(1);
				}
				break;
			}
		}

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
	
}
