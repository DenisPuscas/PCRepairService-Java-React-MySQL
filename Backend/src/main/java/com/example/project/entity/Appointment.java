package com.example.project.entity;

import com.example.project.enumeration.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Appointment {
    /**
     * Id-ul programarii.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Id-ul clientului care a facut programarea.
     */
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    /**
     * Descriere cu problema care trebuie rezolvat sau alte comentarii.
     */
    @Column(nullable = false)
    private String description;
    /**
     * Data si timpul pentru care a fost facuta programarea.
     */
    @Column(nullable = false)
    private LocalDateTime date;
    /**
     * Starea in care se afla dispozitivul.
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    public Appointment() {
    }

    public Appointment(Integer id, Integer idUser, String description, LocalDateTime date, Status status) {
        this.id = id;
        this.idUser = idUser;
        this.description = description;
        this.date = date;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
