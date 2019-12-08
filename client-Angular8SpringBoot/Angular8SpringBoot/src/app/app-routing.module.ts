import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CustomersListComponent } from './customers-list/customers-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';

import { ProductsListComponent } from './products-list/products-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'customer', pathMatch: 'full' },
  { path: 'customer', component: CustomersListComponent },
  { path: 'customer/add', component: CreateCustomerComponent },
  { path: 'customer/findbyage', component: SearchCustomersComponent },
  { path: 'product', component: ProductsListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
