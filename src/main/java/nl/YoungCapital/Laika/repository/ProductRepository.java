package nl.YoungCapital.Laika.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.YoungCapital.Laika.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
