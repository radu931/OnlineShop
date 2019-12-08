package com.rara.spring.restapi.mysql.controller;

import com.rara.spring.restapi.mysql.model.Customer;
import com.rara.spring.restapi.mysql.model.Order;
import com.rara.spring.restapi.mysql.repo.OrderRepository;
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
public class OrderController {

    @Autowired
    OrderRepository repository;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>>getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            repository.findAll().forEach(orders::add);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
        Optional<Order> orderData = repository.findById(id);

        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        try {
            Order _order = repository.save(new Order(order.getDeliveryDate(), order.getOrderProducts(), order.getCustomer(), order.getStatus(), order.getDeliveryCompany(), order.getContactPerson()));
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/orders")
    public ResponseEntity<HttpStatus> deleteAllOrders() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(value = "orders/name/{name}")
    public ResponseEntity<List<Order>> findByCustomer(@PathVariable Customer customer) {
        try {
            List<Order> orders = repository.findByCustomer(customer);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order customer) {
        Optional<Order> orderData = repository.findById(id);

        if (orderData.isPresent()) {
            Order _order = orderData.get();
            _order.setDeliveryDate(_order.getDeliveryDate());
            _order.setCustomer(_order.getCustomer());
            _order.setOrderProducts(_order.getOrderProducts());

            return new ResponseEntity<>(repository.save(_order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
