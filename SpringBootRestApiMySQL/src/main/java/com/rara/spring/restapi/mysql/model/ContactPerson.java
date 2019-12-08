package com.rara.spring.restapi.mysql.model;

import javax.persistence.*;

@Entity
@Table(name = "contactPerson")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNr")
    private String phoneNr;

    @Column(name = "email")
    private String email;

    public ContactPerson(){}
    public ContactPerson(String name, String phoneNr, String email) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.email = email;
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
