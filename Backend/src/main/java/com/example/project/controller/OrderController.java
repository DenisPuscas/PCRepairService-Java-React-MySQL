package com.example.project.controller;

import com.example.project.entity.Order;
import com.example.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private OrderService service;

    /**
     * Adauga o comanda in baza de date.
     * @param order comanda care urmeaza sa fie adaugata
     * @return Order
     */
    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }

    /**
     * Adauga mai multe comenzi in baza de date.
     * @param orders lista de comenzi care urmeaza sa fie adaugate
     * @return lista comenzilor adaugate
     */
    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders){
        return service.saveOrders(orders);
    }

    /**
     * Cauta toate comenzile in baza de date.
     * @return lista comenzilor gasite
     */
    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return service.getOrders();
    }

    /**
     * Cauta o comanda dupa id-ul dat.
     * @param id id-ul comenzii care urmeaza sa fie cautata
     * @return comanda gasita
     */
    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    /**
     * Actualizeaza o anumita comanda.
     * @param order comanda care urmeaza sa fie actualizata
     * @return comanda actualizata
     */
    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        return service.updateOrder(order);
    }

    /**
     * Sterge o anumita comanda.
     * @param id id-ul comenzii care urmeaza sa fie stearsa
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }
}
