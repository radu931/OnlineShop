package com.rara.spring.restapi.mysql.repo;

import java.util.List;

import com.rara.spring.restapi.mysql.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
