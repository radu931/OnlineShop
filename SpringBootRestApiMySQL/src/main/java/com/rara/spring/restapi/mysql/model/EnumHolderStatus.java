package com.rara.spring.restapi.mysql.model;

import javax.persistence.*;

@Entity
public
class EnumHolderStatus{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public EnumHolderStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EnumHolderStatus{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
