package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Clasa Order Product reprezinta un produs care apartine unei anumite comenzi.
 * Contine informatii despre id-ul comenzii, al produsului si cantitatea produsului.
 */
@Entity
@Table(name="ordered_product")
public class OrderedProduct {

    /**
     * Id-ul produsului comandat.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Id-ul comenzii din care face parte produsul.
     */
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    /**
     * Id-ul produsului care a fost comandat.
     */
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;
    /**
     * Cantitatea produselor comandata.
     */
    @Column(nullable = false)
    private Integer quantity;

    public OrderedProduct() {
    }

    public OrderedProduct(Integer id, Integer idOrder, Integer idProduct, Integer quantity) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "id=" + id +
                ", idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                '}';
    }
}
