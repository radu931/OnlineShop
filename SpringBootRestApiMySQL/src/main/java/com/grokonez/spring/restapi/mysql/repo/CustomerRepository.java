package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.spring.restapi.mysql.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
