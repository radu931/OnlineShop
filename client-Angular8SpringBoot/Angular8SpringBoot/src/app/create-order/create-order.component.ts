import { Component, OnInit } from '@angular/core';

import { CustomerService } from '../services/customer.service';
import { ProductService } from '../services/product.service';
import { OrderService } from '../services/order.service';

import { Customer } from '../models/customer';
import { Product } from '../models/product';
import { Order } from '../models/order';
import { Observable } from 'rxjs';

@Component({
	selector: 'create-order',
	templateUrl: 'create-order.component.html'
})

export class CreateOrderComponent implements OnInit {

	customers: Observable<Customer[]>;
	products: Observable<Product[]>;
	order: Order = new Order();
	submitted = false;
	

	constructor(private customerService: CustomerService, private productService: ProductService, private orderService: OrderService) { }

	ngOnInit() { 
		this.reloadData();
	}

	newOrder(): void {
		this.submitted = false;
		this.order = new Order();
	}

	save() {
		this.orderService.createOrder(this.order)
		  .subscribe(
			data => {
			  console.log(data);
			  this.submitted = true;
			},
			error => console.log(error));
		this.order = new Order();
	  }

	  onSubmit() {
		this.save();
	  }

	reloadData() {
		this.customers = this.customerService.getCustomersList();
		this.products = this.productService.getProductsList();
	  }
}