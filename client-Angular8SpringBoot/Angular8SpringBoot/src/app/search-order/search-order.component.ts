import { Component, OnInit } from '@angular/core';

import { Order } from '../models/order';
import { OrderService } from '../services/order.service';

@Component({
	selector: 'search-order',
	templateUrl: 'search-order.component.html'
})

export class SearchOrderComponent implements OnInit {

	customerName: string;
	orders: Order[];

	constructor(private dataService: OrderService) { }


	ngOnInit() {
		this.customerName="";
	}

	private searchOrders() {
		this.orders = [];
		this.dataService.getOrdersByCustomerName(this.customerName)
			.subscribe(orders => this.orders = orders);
	}

	onSubmit() {
		this.searchOrders();

	}
}