package com.example.project.service;

import com.example.project.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductService {

    OrderedProduct saveOrderedProduct(OrderedProduct orderedProduct);
    List<OrderedProduct> saveOrderedProducts(List<OrderedProduct> orderedProducts);
    OrderedProduct getOrderedProductById(int id);
    List<OrderedProduct> getOrderedProducts();
    OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct);
    String deleteOrderedProduct(int id);
}
