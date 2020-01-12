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

	constructor(private customerService: CustomerService, private productService: ProductService) { }

	ngOnInit() { 
		this.reloadData();
	}

	reloadData() {
		this.customers = this.customerService.getCustomersList();
		this.products = this.productService.getProductsList();
	  }
}