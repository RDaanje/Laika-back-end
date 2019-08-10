package nl.YoungCapital.Laika.service;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.YoungCapital.Laika.domain.Orderhistory;
import nl.YoungCapital.Laika.domain.Product;
import nl.YoungCapital.Laika.repository.ProductRepository;
import nl.YoungCapital.Laika.repository.OrderhistoryRepository;

@Service
@Transactional
public class OrderhistoryService {

	@Autowired
	OrderhistoryRepository orderhistoryRepository;
	
	public Iterable<Orderhistory> findAll() {
		return orderhistoryRepository.findAll();
	}

	public Optional<Orderhistory> findById(long id)	{
		return orderhistoryRepository.findById(id);
	}

}
