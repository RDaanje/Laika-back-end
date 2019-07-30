package nl.YoungCapital.Laika.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping(path="get")
	public Iterable<Account> findAll() {
		
		return accountService.findAll();
	}
	
	@PostMapping(path="create")
	public Account create(@RequestBody Account input) {
		
		return accountService.save(input);
		
		
	}
}


