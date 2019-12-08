import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { ProductService } from '../services/product.service';
import { Product } from '../models/product';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products: Observable<Product[]>;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteCustomers() {
    this.productService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.products = this.productService.getProductsList();
  }

}
