package com.rara.spring.restapi.mysql;

import com.rara.spring.restapi.mysql.controller.*;
import com.rara.spring.restapi.mysql.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SpringBootRestApiMySqlApplication {

	@Autowired
	static  ProductController pc = new ProductController();

	@Autowired
	static  CustomerController cc = new CustomerController();

	@Autowired
	static  DeliveryCompanyController dcc = new DeliveryCompanyController();

	@Autowired
	static ContactPersonController cpc = new ContactPersonController();

	@Autowired
	static OrderController orderController = new OrderController();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiMySqlApplication.class, args);

		Date date = new Date();
		date.setTime(1324654895);
		Product product = new Product("Product1", "desription", 2.00);
		List<Product> products = new ArrayList<>();
		products.add(product);

		Customer customer = new Customer("Andrada", 25);
		Status status = Status.Waiting;
		DeliveryCompany deliveryCompany = new DeliveryCompany("companyName", "companyLocation");

		ContactPerson contactPerson = new ContactPerson("name", "05646456", "sdfjlk@gmail.com");

		Order order = new Order(date, products, customer, status, deliveryCompany, contactPerson);

		pc.postProduct(product);
		cc.postCustomer(customer);
		dcc.postCompany(deliveryCompany);
		cpc.postContactPerson(contactPerson);
		orderController.postOrder(order);
	}

/*
 script
INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (0,'Waiting Approval');

	INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (1, 'In Progress');

	INSERT INTO onlineshop.enum_holder_status (id, status)
	VALUES (2,'Sent');*/

}
