package nl.YoungCapital.Laika.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.domain.Cart;
import nl.YoungCapital.Laika.domain.Orderhistory;
import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.domain.Wallet;
import nl.YoungCapital.Laika.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	AccountRepository accountrepository;
	
	// Creates an account
	public Account save(Account account) {		
		return accountrepository.save(account);
	}
	
	// Returns a specific account
	public Optional<Account> findById(Long id) {
		return accountrepository.findById(id);
	}

	// Returns all accounts
	public Iterable<Account> findAll() {
		return accountrepository.findAll();
	}

	// Returns an account with a specific username
	public Optional<Account> findByUsername(String username) {
		return accountrepository.findByUsername(username);
	}
	
	// Returns an account with a specific email
	public Optional<Account> findByEmail(String email) {
		return accountrepository.findByEmail(email);
	}
	
	public Optional<Account> findByUsernameAndPassword(String username, String password) {
		return accountrepository.findByUsernameAndPassword(username, password);
	}

	// Deletes an account (optionele functie)
	public void deleteById(Long id) {
		accountrepository.deleteById(id);
	}
	
@PostConstruct
void initAccountDatabase() {

	account1.setWallet(new Wallet(1000, 1001));
	account1.setCart(new Cart());
	account1.setOrderhistory(new Orderhistory(LocalDateTime.now(), "Order1", false, 100.50));
	accountrepository.save(account1);
	
	account2.setWallet(new Wallet(2000, 2002));
	Cart cart1 = new Cart();
	cart1.setProductInCart(58L);
	account2.setCart(cart1);
	Orderhistory orderhistory1 = new Orderhistory();
	orderhistory1.setAllOrders(cart1);
	account2.setOrderhistory(orderhistory1);
	accountrepository.save(account2);

	accountrepository.save(new Account("", "", "admin", "admin", "admin", "", "", "", "",true));
	Account account1 = accountrepository.save(new Account("Laika", "Isweg", "L", "password", "email", "Moonstreet", "1", "1111LA", "Moontown",false));
	Account account2 = accountrepository.save(new Account("Bert", "Isonderweg", "B", "password", "email", "Rocketstreet", "22", "2222LA", "Rocketcity", false));

	
}

}
