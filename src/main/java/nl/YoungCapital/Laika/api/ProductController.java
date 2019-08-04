package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.service.ProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path= "api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path = "get")
	public Iterable<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping(path = "get/{id}")
	public Optional<Product> findById(@PathVariable long id)	{
		return productService.findById(id);
	}
}

	