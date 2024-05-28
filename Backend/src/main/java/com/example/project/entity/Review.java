package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Clasa Review reprezinta o recenzie plasata de un client pentru un anumit produs.
 * Contine informatii despre id-ul recenziei, id-ul clientului, produsului, nota atribuita de catre client, comentariul pe care il lasa acesta si data in care a fost lasata recenzia.
 */
@Entity
@Table
public class Review {

    /**
     * Id-ul recenziei.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Id-ul clientului care a lasat recenzia.
     */
    @Column(name = "id_user", nullable = false)
    private int idUser;
    /**
     * Id-ul produsului pentru care a fost lasata recenzia.
     */
    @Column(name = "id_product", nullable = false)
    private int idProduct;
    /**
     * Nota lasata ce catre client.
     */
    @Column(nullable = false)
    private Integer rating;
    /**
     * Comentariul lasta de catre client pentru produs.
     */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;
    /**
     * Data in care a fost lasata recenzia.
     */
    @Column(nullable = false)
    private Date date;

    public Review() {
    }

    public Review(Integer id, Integer idUser, Integer idProduct, Integer rating, String comment, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
