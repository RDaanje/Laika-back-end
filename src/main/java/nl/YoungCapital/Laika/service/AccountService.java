package nl.YoungCapital.Laika.service;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.domain.Cart;
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
	
	Account account1 = accountrepository.save(new Account("Laika", "Isweg", "L", "password", "email1", "Moonstreet", "1", "1111LA", "Moontown"));
	Account account2 = accountrepository.save(new Account("Bert", "Isonderweg", "B", "password", "email2", "Rocketstreet", "22", "2222LA", "Rocketcity"));
	
	account1.setWallet(new Wallet(1000, 1001));
	account1.setCart(new Cart());
	accountrepository.save(account1);
	
	account2.setWallet(new Wallet(2000, 2002));
	account2.setCart(new Cart());
	accountrepository.save(account2);
	
}

}
