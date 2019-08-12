package nl.YoungCapital.Laika.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.YoungCapital.Laika.domain.Orderhistory;
import nl.YoungCapital.Laika.service.OrderhistoryService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path= "api/orderhistory", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderhistoryController {
	
	@Autowired
	OrderhistoryService orderhistoryService;
	
	@GetMapping(path = "get")
	public Iterable<Orderhistory> findAll() {
		return orderhistoryService.findAll();
	}
	
	@GetMapping(path = "get/{id}")
	public Optional<Orderhistory> findById(@PathVariable long id)	{
		return orderhistoryService.findById(id);
	}
	

}
