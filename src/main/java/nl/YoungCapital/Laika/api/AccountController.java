package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	public Optional<Account> findById(@PathVariable Long id) {

		return accountService.findById(id);
	}
	

	@PostMapping(path = "create")
	public Account create(@RequestBody Account input) {

		return accountService.save(input);

	}
}
