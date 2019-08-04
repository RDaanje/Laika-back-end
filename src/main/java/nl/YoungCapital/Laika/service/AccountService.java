package nl.YoungCapital.Laika.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.YoungCapital.Laika.domain.Account;
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


}
