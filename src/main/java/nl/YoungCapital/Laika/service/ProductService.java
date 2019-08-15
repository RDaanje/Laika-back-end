package nl.YoungCapital.Laika.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public Iterable<Product> findAllByName(String name){
		return productRepository.findAllByName(name);
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
	
//	productRepository.save(new Product("Bert", "LaikaProduction", 10, 1.99,10, "assets/images/Bert.jpg","Bert is watching you"));
	productRepository.save(new Product("Laika cap", "LaikaProduction", 100, 12.00,3000,"assets/images/Pet.png","For everyday adventures outdoors. The Laika Cap has an adjustable back strap and embroidered logo details."));
	productRepository.save(new Product("Laika t-shirt", "LaikaProduction", 100, 15.00, 3500, "assets/images/Shirt.png", "The official Laika t-shirt."));
	productRepository.save(new Product("Laika vest", "LaikaProduction", 100, 25.00, 4500, "assets/images/Vest.png", "To keep your warm during all your epic adventures in space."));
	productRepository.save(new Product("Laika Phone case", "LaikaProduction", 100, 20.00, 2500, "assets/images/case.png", "Protect your mobile phone with our special Laika phone case." ));
	
	
	
//	productRepository.save(new Product("Laika", "LaikaProduction", 101, 10.99,5, "assets/images/LaikaLogoDog.png",""));
	productRepository.save(new Product("Mars", "LaikaProduction", 11, 5.00,50, "assets/images/Mars.jpg","The special Laika Mars wallpaper"));
	productRepository.save(new Product("Moon", "LaikaProduction", 12, 5.00,50, "assets/images/Moon.jpg","The Very special Laika Moon wallpaper"));
	productRepository.save(new Product("Saturn", "LaikaProduction", 13, 5.00,50, "assets/images/Saturn.jpg","The Mega special Laika Saturn wallpaper"));
	productRepository.save(new Product("Sun", "LaikaProduction", 14,5.00,100, "assets/images/Sun.jpg","The Ultra special Laika Sun wallpaper"));


	}
}