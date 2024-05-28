package com.example.project.service;

import com.example.project.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> saveOrders(List<Order> orders);
    Order getOrderById(int id);
    List<Order> getOrders();
    Order updateOrder(Order order);
    String deleteOrder(int id);
}
