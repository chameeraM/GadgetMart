

package com.edu.soap.gadgetMart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String itemid;
    private String brandid;
    private String subcatid;
    private String name;
    private String status;
    private String imageUrl;
    private float price;
    private double discount;
    private int warranty;
    private int qty;
    private String itemtype;
    private String longdes;
    private String shortdes;


}
