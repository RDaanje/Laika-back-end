package nl.YoungCapital.Laika.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.YoungCapital.Laika.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

	Iterable<Account> findByUsername(String username);
	
	Iterable<Account> findByEmail(String email);

	Iterable<Account> findByUsernameAndPassword(String username, String password);
	
}
