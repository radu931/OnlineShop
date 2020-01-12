import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CustomersListComponent } from './customers-list/customers-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';

import { ProductsListComponent } from './products-list/products-list.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { SearchProductsComponent } from './search-products/search-products.component';
import { OrederDetailsComponent } from './oreder-details/oreder-details.component';
import { SearchOrderComponent } from './search-order/search-order.component';
import { CreateOrderComponent } from './create-order/create-order.component';

const routes: Routes = [
  { path: '', redirectTo: 'customer', pathMatch: 'full' },
  { path: 'customer', component: CustomersListComponent },
  { path: 'customer/add', component: CreateCustomerComponent },
  { path: 'customer/findbyage', component: SearchCustomersComponent },
  { path: 'product', component: ProductsListComponent },
  { path: 'product/add', component: CreateProductComponent },
  { path: 'product/findbyname', component: SearchProductsComponent },
  { path: 'order', component: OrederDetailsComponent },
  { path: 'order/add', component: CreateOrderComponent },
  { path: 'order/findbycustomer', component: SearchOrderComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
