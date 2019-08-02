package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/account", produces = MediaType.APPLICATION_JSON_VALUE)

public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(path = "get")
	public Iterable<Account> findAll() {

		return accountService.findAll();
	}
//	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	@GetMapping(path= "{id}")
	public Optional<Account> findById(@PathVariable Long id) {

		return accountService.findById(id);
	}
	
	@GetMapping(path= "forgotpassword/{email}")
	public Optional<Account> findByEmail(@PathVariable String email){
		return accountService.findByEmail(email);
	}
	
//	@GetMapping(path= "forgotusername/{email}")
//	public Optional<Account> findByEmail(@PathVariable String email){
//		return accountService.findByEmail(email);
//	}
	
	@PostMapping(path = "create")
	public Account create(@RequestBody Account input) {

		return accountService.save(input);

	}
	
	@PutMapping(path = "{id}/{email}")
	public Optional<Account> changeEmail(@PathVariable("id") long id, @PathVariable("email") String email){
		accountService.findById(id).get().setEmail(email);
		return accountService.findById(id);
	}
}
