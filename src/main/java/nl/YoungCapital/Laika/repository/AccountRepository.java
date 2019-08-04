package nl.YoungCapital.Laika.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.YoungCapital.Laika.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

	Optional<Account> findByUsername(String username);
	
	Optional<Account> findByEmail(String email);

	@Query
	Optional<Account> findByUsernameAndPassword(String username, String password);


	
	 
	
}
