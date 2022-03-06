

package com.edu.gadgetMart.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommonOrderModel {

    private long id;
    private String customer;

    private String contact;
    private String date;
    private double fullAmount;
    private String orderAddress;
    private List<OrderDetailsModel> orderDetailsModels=new ArrayList<>();

    public CommonOrderModel(String customer, String contact, double fullAmount, String orderAddress, List<OrderDetailsModel> orderDetailsModels) {
        this.customer = customer;
        this.contact = contact;
        this.fullAmount = fullAmount;
        this.orderAddress = orderAddress;
        this.orderDetailsModels = orderDetailsModels;
    }
}
