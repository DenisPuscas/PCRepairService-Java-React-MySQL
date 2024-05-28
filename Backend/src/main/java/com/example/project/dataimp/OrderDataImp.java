package com.example.project.dataimp;

import com.example.project.data.OrderData;
import com.example.project.entity.Order;
import com.example.project.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței OrderData.
 * Ea comunică cu repository-ul OrderRepository pentru a efectua operații legate de comenzi.
 */
@Component
public class OrderDataImp implements OrderData {

    private final OrderRepository repo;

    /**
     * Construiește o nouă instanță a clasei OrderDataImp cu OrderRepository specificat.
     *
     * @param repo Obiectul OrderRepository care va fi utilizat pentru accesul la date.
     */
    public OrderDataImp(OrderRepository repo) {
        this.repo = repo;
    }

    /**
     * Salvează o comandă în sistem.
     *
     * @param order Obiectul comenzii de salvat.
     * @return Obiectul comenzii salvate.
     */
    @Override
    public Order saveOrder(Order order) {
        return repo.save(order);
    }

    /**
     * Salvează o listă de comenzi în sistem.
     *
     * @param orders Lista obiectelor de comenzi de salvat.
     * @return Lista obiectelor de comenzi salvate.
     */
    @Override
    public List<Order> saveOrders(List<Order> orders) {
        return repo.saveAll(orders);
    }

    /**
     * Recuperează toate comenzile din sistem.
     *
     * @return O listă cu toate obiectele de comenzi.
     */
    @Override
    public List<Order> getOrders() {
        return repo.findAll();
    }

    /**
     * Recuperează o comandă după ID-ul său.
     *
     * @param id ID-ul comenzii de recuperat.
     * @return Obiectul comenzii corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public Order getOrderById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Șterge o comandă din sistem după ID-ul său.
     *
     * @param id ID-ul comenzii de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteOrder(int id) {
        repo.deleteById(id);
        return "Order " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unei comenzi existente.
     *
     * @param order Obiectul comenzii actualizate.
     * @return Obiectul comenzii actualizate.
     */
    @Override
    public Order updateOrder(Order order) {
        return repo.save(order);
    }
}
