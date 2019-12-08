package com.rara.spring.restapi.mysql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date deliveryDate;


//
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate dateCreated;

//    private String status;

    @OneToMany
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private List<Product> orderProducts = new ArrayList<>();

    @ManyToOne
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private Customer customer;




    public Order(){}

//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List<OrderProduct> orderProducts = getOrderProducts();
//        for (OrderProduct op : orderProducts) {
//            sum += op.getTotalPrice();
//        }
//        return sum;
//    }
//
//    @Transient
//    public int getNumberOfProducts() {
//        return this.orderProducts.size();
//    }
//
//    // standard getters and setters
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDate getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDate dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<OrderProduct> getOrderProducts() {
//        return orderProducts;
//    }
//
//    public void setOrderProducts(List<OrderProduct> orderProducts) {
//        this.orderProducts = orderProducts;
//    }
}