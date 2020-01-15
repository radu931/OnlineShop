import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BsDropdownModule, TabsModule, PaginationModule, ButtonsModule, BsDatepickerModule } from 'ngx-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';
import { ProductsListComponent } from './products-list/products-list.component';
import { SearchProductsComponent } from './search-products/search-products.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { OrederDetailsComponent } from './oreder-details/oreder-details.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { SearchOrderComponent } from './search-order/search-order.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateCustomerComponent,
    CustomerDetailsComponent,
    CustomersListComponent,
    SearchCustomersComponent,
    ProductsListComponent,
    SearchProductsComponent,
    CreateProductComponent,
    OrederDetailsComponent,
    CreateOrderComponent,
    SearchOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BsDropdownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
