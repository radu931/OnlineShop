import { Component, OnInit } from '@angular/core';

import { Customer } from '../models/customer';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-search-customers',
  templateUrl: './search-customers.component.html',
  styleUrls: ['./search-customers.component.css']
})
export class SearchCustomersComponent implements OnInit {

  age: number;
  customers: Customer[];

  constructor(private dataService: CustomerService) { }

  ngOnInit() {
    this.age = 0;
  }

  private searchCustomers() {
    this.customers = [];
    this.dataService.getCustomersByAge(this.age)
      .subscribe(customers => this.customers = customers);
  }

  onSubmit() {
    this.searchCustomers();
  }

}
