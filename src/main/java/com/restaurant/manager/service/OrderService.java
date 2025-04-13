package com.restaurant.manager.service;

import com.restaurant.manager.entity.Order;
import com.restaurant.manager.entity.OrderItem;
import com.restaurant.manager.repository.OrderItemRepository;
import com.restaurant.manager.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Transactional
    public Order createOrder(Order order) {
        Order createdOrder = new Order();
        createdOrder.setRestaurantId(order.getRestaurantId());
        createdOrder.setTableId(order.getTableId());
        createdOrder.setOrderItems(order.getOrderItems());
        createdOrder.setBillAmount(order.getBillAmount());
        createdOrder.setStatus(order.getStatus());

        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem : orderItems){
            orderItem.setOrder(createdOrder);
            orderItem.setServedUnits(0);
        }

        orderItemRepository.saveAll(orderItems);
        orderRepository.save(createdOrder);

        return createdOrder;
    }

    public Order getOrderFromTable(Long restaurantId, Long tableId){
        List<Order> foundOrder = orderRepository.findByTableId(tableId);
        return foundOrder.get(0);
    }
}
