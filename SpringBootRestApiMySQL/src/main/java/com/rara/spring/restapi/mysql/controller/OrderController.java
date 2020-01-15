package com.rara.spring.restapi.mysql.controller;

import com.rara.spring.restapi.mysql.model.Customer;
import com.rara.spring.restapi.mysql.model.Order;
import com.rara.spring.restapi.mysql.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        try {
            Date orderDate = new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(orderDate);
            c.add(Calendar.DATE, 1);
            Date deliveryDate = c.getTime();

            Order _order = repository.save(new Order(order.getCustomer(), order.getProduct(), orderDate, deliveryDate));
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "orders/name/{customerName}")
    public ResponseEntity<List<Order>> findByCustomerName(@PathVariable String customerName) {
        try {
            List<Order> orders = repository.findByCustomer(customerName);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
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

}
