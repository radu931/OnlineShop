package com.rara.spring.restapi.mysql.repo;

import com.rara.spring.restapi.mysql.model.Customer;
import com.rara.spring.restapi.mysql.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomer(String customerName);
}
