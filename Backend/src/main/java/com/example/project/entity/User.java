package com.example.project.entity;

import com.example.project.observer.Observer;
import jakarta.persistence.*;

/**
 * Clasa User reprezinta un client din cadrul magazinului.
 * Contine informatii despre id-ul clientului, numele acestuia, email-ul, parola, numarul de telefon si adresa acestuai.
 */
@Entity
@Table
public class User implements Observer {

    /**
     * Id-ul clientului.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * Prenumele clientului.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;
    /**
     * Numele clientului.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;
    /**
     * Email-ul clientului.
     */
    @Column(nullable = false, unique = true)
    private String email;
    /**
     * Parola clientului.
     */
    @Column(nullable = false)
    private String password;
    /**
     * Numarul de telefon al clientului.
     */
    @Column(nullable = false)
    private String phone;
    /**
     * Adresa clientului.
     */
    @Column(nullable = false)
    private String address;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * Notifica clientul cu un anumit mesaj.
     * @param msg mesajul cu care este notificat clientul.
     */
    @Override
    public void update(String msg) {
        System.out.println("Clientul " + id + " a fost notificat cu mesajul: " + msg);
    }
}
