package nl.YoungCapital.Laika.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.YoungCapital.Laika.domain.Orderhistory;

@Repository
public interface OrderhistoryRepository extends CrudRepository<Orderhistory, Long>{


}
