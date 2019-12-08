package com.rara.spring.restapi.mysql.model;

import javax.persistence.*;

@Entity
@Table(name = "deliveryCompany")
public class DeliveryCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "companyLocation")
    private String companyLocation;

    public DeliveryCompany(){}
    public DeliveryCompany(String name, String companyLocation) {
        this.name = name;
        this.companyLocation = companyLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    @Override
    public String toString() {
        return "DeliveryCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                '}';
    }
}
