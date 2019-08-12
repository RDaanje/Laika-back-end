package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Account;
import nl.YoungCapital.Laika.domain.Cart;
import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.domain.Wallet;
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
	
	@GetMapping(path = "get/name/{name}")
	public Optional<Product> findByName(@PathVariable String name)	{
		return productService.findByName(name);
	}
	
	
	@PostMapping(path = "create")
	public ResponseEntity<Product> create(@RequestBody Product input) {

		Optional<Product> productCheck = productService.findByName(input.getName());
		
		if (productCheck.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.CONFLICT);
		} else {		
			return new ResponseEntity<Product>(productService.save(input), HttpStatus.OK);
		}
					
	}
	

	@PutMapping(path= "{id}/update")
	public Product productUpdate(@PathVariable long id, @RequestBody Product product) {
		Optional<Product> accountCheck = productService.findById(product.getId());	//lijkt overbodig
	
		return productService.save(product);
	} 
  
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable("id") long id) {
		if (!productService.findById(id).isPresent()) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			productService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}


	@DeleteMapping(path= "{id}/delete")
	public ResponseEntity<Product> deleteProduct(@PathVariable long id)	{
	
		if (!productService.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		} else {
			productService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
	