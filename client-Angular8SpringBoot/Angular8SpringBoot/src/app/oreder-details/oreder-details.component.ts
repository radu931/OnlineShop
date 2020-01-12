import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { CustomerService } from '../services/customer.service';
import { ProductService } from '../services/product.service';
import { OrderService } from '../services/order.service';

import { Order } from '../models/order';
import { Customer } from '../models/customer';
import { Product } from '../models/product';

@Component({
	selector: 'oreder-details',
	templateUrl: 'oreder-details.component.html',
  styleUrls: ['./oreder-details.component.css']
})
export class OrederDetailsComponent implements OnInit {

  orders: Observable<Order[]>;
  customers: Observable<Customer[]>;
	products: Observable<Product[]>;

  constructor(private orderService: OrderService, private customerService: CustomerService, private productService: ProductService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteProducts() {
    this.orderService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.orders = this.orderService.getOrdersList();
    this.customers = this.customerService.getCustomersList();
		this.products = this.productService.getProductsList();
  }

}
