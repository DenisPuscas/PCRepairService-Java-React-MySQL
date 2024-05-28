package com.example.project.data;

import com.example.project.entity.Order;

import java.util.List;

public interface OrderData {

    Order saveOrder(Order order);
    List<Order> saveOrders(List<Order> orders);
    List<Order> getOrders();
    Order getOrderById(int id);
    String deleteOrder(int id);
    Order updateOrder(Order order);
}
