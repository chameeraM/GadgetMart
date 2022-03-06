

package com.edu.soap.gadgetMart.service.impl;

import com.edu.soap.gadgetMart.entity.Item;
import com.edu.soap.gadgetMart.entity.OrderDetails;
import com.edu.soap.gadgetMart.entity.Orders;
import com.edu.soap.gadgetMart.exception.RecordNotFoundException;
import com.edu.soap.gadgetMart.model.CommonOrderModel;
import com.edu.soap.gadgetMart.model.OrderDetailsModel;
import com.edu.soap.gadgetMart.repository.ItemRepository;
import com.edu.soap.gadgetMart.repository.OrderDetailsRepository;
import com.edu.soap.gadgetMart.repository.OrderRepository;
import com.edu.soap.gadgetMart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Orders addOrder(CommonOrderModel commonOrderModel) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String todaydate=dtf.format(now);
        OrderDetails orderDetails = null;
        Orders save = new Orders(commonOrderModel.getCustomer(), commonOrderModel.getContact(), todaydate, commonOrderModel.getFullAmount(), commonOrderModel.getOrderAddress());
        Orders orders = orderRepository.save(save);
        for (OrderDetailsModel orderDetailsModel : commonOrderModel.getOrderDetailsModels()) {
            Object item1=null;
            Item item = null;
            try{
                item1 = itemRepository.findById(Long.parseLong(orderDetailsModel.getItem()));
                 item = (Item) item1;
                 if(item == null){
                     throwdata(orders);
                     return null;
                 }
            }catch (Exception exception){
                this.thrownumberexceptiondata(orders);
                return null;
            }

            if (item.getQty() >= orderDetailsModel.getQty()) {
                if (item != null) {
                    double price=orderDetailsModel.getQty()*item.getPrice();
                    orderDetails = new OrderDetails(item.getId() + "", orderDetailsModel.getQty(), price, orders.getId() + "");
                    orderDetailsRepository.save(orderDetails);
                    int qty = item.getQty()-orderDetailsModel.getQty();
                    item.setQty(qty);
                    orderDetailsRepository.save(orderDetails);
                    itemRepository.save(item);
                }
            } else {
                this.throwdata(orders);
            }

        }
        if (orderDetails == null) {
            orderRepository.delete(orders);
        }
        return orders;
    }

    private void throwdata(Orders order) {
        orderRepository.delete(order);
        throw new RecordNotFoundException("error");
    }

    private void thrownumberexceptiondata(Orders order) {
        orderRepository.delete(order);
        throw new RecordNotFoundException("error");
    }
    @Override
    public CommonOrderModel findbyOrderId(long id) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Order Not Found"));
        List<OrderDetails> orderDetailsByOrder = orderDetailsRepository.findOrderDetailsByOrders(id+"");
        List<OrderDetailsModel> orderDetailsModels = new ArrayList<>();
        for (OrderDetails orderDetails : orderDetailsByOrder) {
            orderDetailsModels.add(new OrderDetailsModel(orderDetails.getId(), orderDetails.getItem(), orderDetails.getQty(), orderDetails.getPrice()));
        }
        return new CommonOrderModel(orders.getId(), orders.getCustomer(), orders.getContact(), orders.getDate(), orders.getFullAmount(), orders.getOrderAddress(), orderDetailsModels);
    }


}
