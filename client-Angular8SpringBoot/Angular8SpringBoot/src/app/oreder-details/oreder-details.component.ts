import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { OrderService } from '../services/order.service';
import { Order } from '../models/order';

@Component({
	selector: 'oreder-details',
	templateUrl: 'oreder-details.component.html',
  styleUrls: ['./oreder-details.component.css']
})
export class OrederDetailsComponent implements OnInit {

  orders: Observable<Order[]>;

  constructor(private orderService: OrderService) { }

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
  }

}
