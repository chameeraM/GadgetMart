

package com.edu.gadgetMart.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customer;

    private String contact;
    private String date;
    private double fullAmount;
    private String orderAddress;

    public Orders(String customer, String contact, String date, double fullAmount, String orderAddress) {
        this.customer = customer;
        this.contact = contact;
        this.date = date;
        this.fullAmount = fullAmount;
        this.orderAddress = orderAddress;
    }
}
