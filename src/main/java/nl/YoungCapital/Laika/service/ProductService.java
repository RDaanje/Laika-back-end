package nl.YoungCapital.Laika.service;

import java.util.Optional;

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

	public Optional<Product> findById(long id)	{
		return productRepository.findById(id);
	}
	
	public Optional<Product> findByName(String name)	{
		return productRepository.findByName(name);
	}

	public Product save(Product input) {
		// TODO Auto-generated method stub
		return productRepository.save(input);
	}
}
