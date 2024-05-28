package com.example.project.serviceimp;

import com.example.project.data.OrderData;
import com.example.project.entity.Order;
import com.example.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței OrderService.
 * Ea comunică cu stratul de date OrderData pentru a efectua operații legate de comenzi.
 */
@Service
public class OrderServiceImp implements OrderService {

    private final OrderData data;

    /**
     * Construiește o nouă instanță a clasei OrderServiceImp cu OrderData specificat.
     *
     * @param data Obiectul OrderData care va fi utilizat pentru accesul la date.
     */
    public OrderServiceImp(OrderData data) {
        this.data = data;
    }

    /**
     * Salvează o comandă în sistem.
     *
     * @param order Obiectul comenzii de salvat.
     * @return Obiectul comenzii salvate.
     */
    public Order saveOrder(Order order) {
        return data.saveOrder(order);
    }

    /**
     * Salvează o listă de comenzi în sistem.
     *
     * @param orders Lista obiectelor de comenzi de salvat.
     * @return Lista obiectelor de comenzi salvate.
     */
    public List<Order> saveOrders(List<Order> orders) {
        return data.saveOrders(orders);
    }

    /**
     * Recuperează toate comenzile din sistem.
     *
     * @return O listă cu toate obiectele de comenzi.
     */
    public List<Order> getOrders() {
        return data.getOrders();
    }

    /**
     * Recuperează o comandă după ID-ul său.
     *
     * @param id ID-ul comenzii de recuperat.
     * @return Obiectul comenzii corespunzător ID-ului furnizat, sau null dacă nu a fost găsită.
     */
    public Order getOrderById(int id) {
        return data.getOrderById(id);
    }

    /**
     * Șterge o comandă din sistem după ID-ul său.
     *
     * @param id ID-ul comenzii de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    public String deleteOrder(int id) {
        return data.deleteOrder(id);
    }

    /**
     * Actualizează informațiile unei comenzi existente.
     *
     * @param order Obiectul comenzii actualizate.
     * @return Obiectul comenzii actualizate, sau null dacă comanda nu a fost găsită.
     */
    public Order updateOrder(Order order) {
        Order existingOrder = data.getOrderById(order.getId());
        if (existingOrder == null) {
            System.out.println("Comanda nu a fost găsită!");
            return null;
        }
        existingOrder.setUserName(order.getUserName());
        existingOrder.setPrice(order.getPrice());
        existingOrder.setDate(order.getDate());
        return data.updateOrder(existingOrder);
    }
}
