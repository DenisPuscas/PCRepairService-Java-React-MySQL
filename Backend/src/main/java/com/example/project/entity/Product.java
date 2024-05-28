package com.example.project.entity;

import com.example.project.enumeration.Category;
import jakarta.persistence.*;

/**
 * Clasa Product reprezinta un produs aflat in stock.
 * Contine informatii despre id-ul, numele, pretulu, cantitatea produsului si categoria in care se afla acesta.
 */
@Entity
@Table
public class Product {

    /**
     * Id-ul produsului.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Numele produsului.
     */
    @Column(nullable = false)
    private String name;
    /**
     * Cantitatea produselor disponibile.
     */
    @Column(nullable = false)
    private Integer quantity;
    /**
     * Pretul produsului.
     */
    @Column(nullable = false)
    private Double price;
    /**
     * Categoria din care face parte produsul.
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Category category;
    /**
     * Imaginea produsului
     */
    @Column(nullable = false)
    private String image;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, Category category, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
