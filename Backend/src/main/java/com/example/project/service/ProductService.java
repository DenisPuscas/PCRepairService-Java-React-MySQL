package com.example.project.service;

import com.example.project.entity.Product;
import com.example.project.enumeration.Category;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    Product getProductById(int id);
    List<Product> getProductByName(String name);
    List<Product> getProductByCategory(Category category);
    List<Product> getProducts();
    Product updateProduct(Product product);
    String deleteProduct(int id);
}
