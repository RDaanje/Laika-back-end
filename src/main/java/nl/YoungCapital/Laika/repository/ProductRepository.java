package nl.YoungCapital.Laika.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.YoungCapital.Laika.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	Optional<Product> findByName(String name);
	
	

}
