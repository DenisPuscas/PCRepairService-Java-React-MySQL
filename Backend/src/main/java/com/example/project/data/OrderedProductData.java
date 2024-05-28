package com.example.project.data;

import com.example.project.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductData {

    OrderedProduct saveOrderedProduct(OrderedProduct orderedProduct);
    List<OrderedProduct> saveOrderedProducts(List<OrderedProduct> orderedProducts);
    List<OrderedProduct> getOrderedProducts();
    OrderedProduct getOrderedProductById(int id);
    String deleteOrderedProduct(int id);
    OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct);
}
