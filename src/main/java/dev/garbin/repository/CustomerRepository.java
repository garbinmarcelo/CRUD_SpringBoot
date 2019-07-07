package dev.garbin.repository;

import dev.garbin.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * appspring_gradle
 *
 * @author Marcelo Garbin
 * @version 1.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    public Customer findByName(String name);
}
