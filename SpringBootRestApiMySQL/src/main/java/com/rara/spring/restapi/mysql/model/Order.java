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

    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @OneToMany(fetch = FetchType.EAGER)
  //  @OnDelete(action =  OnDeleteAction.CASCADE)
    private List<Product> orderProducts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(cascade = CascadeType.REMOVE)
    private DeliveryCompany deliveryCompany;

    @OneToOne(cascade = CascadeType.REMOVE)
   // @OnDelete(action =  OnDeleteAction.CASCADE)
    private ContactPerson contactPerson;

    public Order(){}

    public Order(Date deliveryDate, List<Product> orderProducts, Customer customer, Status status, DeliveryCompany deliveryCompany,
                 ContactPerson contactPerson) {
        this.deliveryDate = deliveryDate;
        this.orderProducts.addAll(orderProducts);
        this.customer = customer;
        this.status = status;
        this.deliveryCompany = deliveryCompany;
        this.contactPerson = contactPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<Product> orderProducts) {
        this.orderProducts.clear();
        this.orderProducts.addAll(orderProducts);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DeliveryCompany getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(DeliveryCompany deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deliveryDate=" + deliveryDate +
                ", orderProducts=" + orderProducts +
                ", customer=" + customer +
                ", status=" + status +
                ", deliveryCompany=" + deliveryCompany +
                ", contactPerson=" + contactPerson +
                '}';
    }
}