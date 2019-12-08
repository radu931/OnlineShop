package com.grokonez.spring.restapi.mysql.repo;

import com.grokonez.spring.restapi.mysql.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByName(String name);
}
