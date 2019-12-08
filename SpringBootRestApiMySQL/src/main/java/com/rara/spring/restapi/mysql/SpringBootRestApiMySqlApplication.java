package com.rara.spring.restapi.mysql;

import com.rara.spring.restapi.mysql.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class SpringBootRestApiMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiMySqlApplication.class, args);
	}

//	Date date = new Date();
//	Product product = new Product("Product1", "desription", 2.00);
//	Customer customer = new Customer("Andrada", 25, true);
//	Status status = Status.Waiting;
//	DeliveryCompany deliveryCompany = new DeliveryCompany()
//
//	Order order = new Order(date,product, customer, status,
//	);
//
//	public Order(Date deliveryDate, List<Product> orderProducts, Customer customer, Status status, DeliveryCompany deliveryCompany,
//				 ContactPerson contactPerson) {
//		this.deliveryDate = deliveryDate;
//
/*
 script
INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (0,'Waiting Approval');

	INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (1, 'In Progress');

	INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (2,'Sent');*/

}
