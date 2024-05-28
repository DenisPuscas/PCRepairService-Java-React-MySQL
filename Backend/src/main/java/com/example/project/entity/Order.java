package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Clasa Order reprezinta o comanda plasata de catre client.
 * Contine informatii despre id-ul comenzii, numele clientului, pretul comenzii si data in care aceasta a fost plasata.
 */
@Entity
@Table(name="orders")
public class Order {

    /**
     * Id-ul comenzii.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Id-ul clientului care a plasat comanda.
     */
    @Column(name = "id_user", nullable = false)
    private int idUser;
    /**
     * Pretul total al comenzii.
     */
    @Column(nullable = false)
    private Double price;
    /**
     * Data in care a fost plasata comanda.
     */
    @Column(nullable = false)
    private Date date;

    public Order() {
    }

    public Order(Integer id, Integer idUser, Double price, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserName() {
        return idUser;
    }

    public void setUserName(Integer idUser) {
        this.idUser = idUser;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser='" + idUser + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
