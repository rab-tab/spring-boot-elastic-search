package com.spring.elasticsearch;

import com.spring.elasticsearch.model.Customer;
import com.spring.elasticsearch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class SpringElasticSearchApplication {

    @Autowired
    private CustomerRepository repository;

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers) {
        repository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/findByFName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        return repository.findByFirstname(firstName);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringElasticSearchApplication.class, args);
    }

}
