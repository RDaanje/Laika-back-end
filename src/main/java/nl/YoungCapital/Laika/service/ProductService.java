package nl.YoungCapital.Laika.service;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	public Optional<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

public Product save(Product product) {
	return productRepository.save(product);
}
public void deleteById(Long id) {
	productRepository.deleteById(id);
}


@PostConstruct
void initProductDatabase() {
	productRepository.save(new Product("Venus", "LaikaProduction", 10, 100.99, "assets/images/Venus.jpg"));
	productRepository.save(new Product("Mercury", "LaikaProduction", 101, 199.99, "assets/images/Mercury.jpg"));
	productRepository.save(new Product("Mars", "LaikaProduction", 11, 299.99, "assets/images/Mars.jpg"));
	productRepository.save(new Product("Moon", "LaikaProduction", 12, 399.99, "assets/images/Moon.jpg"));
	productRepository.save(new Product("Saturnus", "LaikaProduction", 13, 499.99, "assets/images/Saturn.jpg"));
	productRepository.save(new Product("Sun", "LaikaProduction", 14, 99999.99, "assets/images/Sun.jpg"));


	}
}