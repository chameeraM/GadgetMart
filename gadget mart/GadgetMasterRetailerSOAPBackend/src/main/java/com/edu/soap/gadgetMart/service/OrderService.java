

package com.edu.soap.gadgetMart.service;


import com.edu.soap.gadgetMart.entity.Orders;
import com.edu.soap.gadgetMart.model.CommonOrderModel;

public interface OrderService {

    public Orders addOrder(CommonOrderModel commonOrderModel);
    public CommonOrderModel findbyOrderId(long id);
}
