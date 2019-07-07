package dev.garbin.controllers;

import dev.garbin.entity.Customer;
import dev.garbin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * appspring_gradle
 *
 * @author Marcelo Garbin
 * @version 1.0
 */
@Controller
@RequestMapping(path = "/customers")
public class CustomerController{
    @Autowired
    private CustomerRepository repository;

    public CustomerController(CustomerRepository customerRepository){
        this.repository = customerRepository;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Customer> findOne(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping(path = "/name/{name}")
    @ResponseBody
    public Optional<Customer> findOne(@PathVariable String name){
        return Optional.ofNullable(repository.findByName(name));
    }

    @PostMapping
    @ResponseBody
    public Customer create(@RequestParam String name, @RequestParam Integer age){
        Customer customer = new Customer(name, age);
        if(name != null && name.length() > 0 && age != null && age > 0)
            repository.save(customer);

        return customer;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public Boolean destroy(@PathVariable Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));

        if(customer != null){
            repository.delete(customer);
            return true;
        }

        return false;
    }

    @PutMapping(path = "/{id}")
    @ResponseBody
    public Customer update(@PathVariable Long id, @RequestParam String name, @RequestParam Integer age){
        Customer customerUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));

        customerUpdate.setName(name);
        customerUpdate.setAge(age);

        return repository.save(customerUpdate);
    }


    /*// Via JSON
    @PutMapping(path = "/{id}")
    @ResponseBody
    public Customer update(@PathVariable Long id, @RequestBody Customer customer){
        Customer customerUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));

        customerUpdate.setName(customer.getName());
        customerUpdate.setAge(customer.getAge());

        return repository.save(customerUpdate);
    }*/
}
