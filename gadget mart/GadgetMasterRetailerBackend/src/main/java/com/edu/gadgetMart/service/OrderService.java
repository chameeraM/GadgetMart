

package com.edu.gadgetMart.service;


import com.edu.gadgetMart.entity.Orders;
import com.edu.gadgetMart.model.CommonOrderModel;

public interface OrderService {

    public Orders addOrder(CommonOrderModel commonOrderModel);
    public CommonOrderModel findbyOrderId(long id);
}
