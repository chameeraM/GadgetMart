

package com.edu.soap.gadgetMart.repository;

import com.edu.soap.gadgetMart.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    List<OrderDetails> findOrderDetailsByOrders(String order);



}
