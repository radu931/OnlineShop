package com.grokonez.spring.restapi.mysql.controller;

import com.grokonez.spring.restapi.mysql.model.Product;
import com.grokonez.spring.restapi.mysql.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = new ArrayList<>();
		try {
			repository.findAll().forEach(products::add);
			
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> productData = repository.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/products")
	public ResponseEntity<Product> postProduct(@RequestBody Product product) {
		try {
			Product _product = repository.save(new Product(product.getName(),product.getDescription(),product.getPrice()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(value = "customers/name/{name}")
	public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
		try {
			List<Product> customers = repository.findByName(name);

			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product customer) {
		Optional<Product> productData = repository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setName(customer.getName());

			return new ResponseEntity<>(repository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
