package nl.YoungCapital.Laika.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;

@RestController
@RequestMapping("api/account")
public class AccountController {

	private List<Account> accounts = new ArrayList<Account>();
	
	@GetMapping
	public List<Account> findAll() {
		
		return this.accounts;
	}
	
	@PostMapping
	public Account create(@RequestBody Account input) {
		
		this.accounts.add(input);
		return accounts.get(accounts.size()-1);
		
	}
}


