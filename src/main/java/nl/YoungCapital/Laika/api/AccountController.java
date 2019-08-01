package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.service.AccountService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/account", produces = MediaType.APPLICATION_JSON_VALUE)

public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(path = "get")
	public Iterable<Account> findAll() {

		return accountService.findAll();
	}

	@GetMapping(path= "{id}")
	public Optional<Account> findById(@PathVariable Long id) {

		return accountService.findById(id);
	}
	
//	@GetMapping(path= "{username}")
//	public ResponseEntity<Account> findByUsername(@PathVariable String username) {
//		Optional<Account> optAccount = accountService.findByUsername(username);
//		if (optAccount.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@GetMapping
	public Iterable<Account> findByUsernameAndPassword(@RequestBody Account account) {
		return accountService.findByUsernamePassword(account.getUsername(), account.getPassword());
	}
	
	@PutMapping(path= "{id}/update")
	public Account accountUpdate(@PathVariable long id, @RequestBody Account account) {
		Optional<Account> accountCheck = accountService.findById(account.getId());
		
		accountCheck.get().setFirstname(account.getFirstname());
		accountCheck.get().setLastname(account.getLastname());
		
		
		return accountService.save(account);
	} 
	
	@PostMapping(path = "create")
	public Account create(@RequestBody Account input) {

		return accountService.save(input);
	}
	
	@PutMapping(path="{id}/{email}")
	public Optional<Account> updateEmail(@PathVariable("id") long id, @PathVariable("email") String email) {
		accountService.findById(id).get().setEmail(email);
		return accountService.findById(id);
	}
	
	
	
}
