package com.rara.spring.restapi.mysql.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer")
    private String customer;

    @Column(name = "product")
    private String product;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "deliveryDate")
    private Date deliveryDate;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Order(){}

    public Order(String customer, String product, Date orderDate, Date deliveryDate) {
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + " , product=" + product + ", orderDate=" + orderDate +"  , deliveryDate="+ deliveryDate +" ]";
    }
}