package com.example.project.data;

import com.example.project.entity.Product;
import com.example.project.enumeration.Category;

import java.util.List;

public interface ProductData {

    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    Product getProductById(int id);
    List<Product> getProductByName(String name);
    List<Product> getProductByCategory(Category category);
    String deleteProduct(int id);
    Product updateProduct(Product product);
}
