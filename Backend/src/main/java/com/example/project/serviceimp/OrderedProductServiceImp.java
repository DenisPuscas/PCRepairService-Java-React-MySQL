package com.example.project.serviceimp;

import com.example.project.data.OrderedProductData;
import com.example.project.entity.Order;
import com.example.project.entity.OrderedProduct;
import com.example.project.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței OrderedProductService.
 * Ea comunică cu stratul de date OrderedProductData pentru a efectua operații legate de produsele comandate.
 */
@Service
public class OrderedProductServiceImp implements OrderedProductService {

    private final OrderedProductData data;

    /**
     * Construiește o nouă instanță a clasei OrderedProductServiceImp cu OrderedProductData specificat.
     *
     * @param data Obiectul OrderedProductData care va fi utilizat pentru accesul la date.
     */
    public OrderedProductServiceImp(OrderedProductData data) {
        this.data = data;
    }

    /**
     * Salvează un produs comandat în sistem.
     *
     * @param orderedProduct Obiectul produsului comandat de salvat.
     * @return Obiectul produsului comandat salvat.
     */
    public OrderedProduct saveOrderedProduct(OrderedProduct orderedProduct) {
        return data.saveOrderedProduct(orderedProduct);
    }

    /**
     * Salvează o listă de produse comandate în sistem.
     *
     * @param orderedProducts Lista obiectelor de produse comandate de salvat.
     * @return Lista obiectelor de produse comandate salvate.
     */
    public List<OrderedProduct> saveOrderedProducts(List<OrderedProduct> orderedProducts) {
        return data.saveOrderedProducts(orderedProducts);
    }

    /**
     * Recuperează toate produsele comandate din sistem.
     *
     * @return O listă cu toate obiectele de produse comandate.
     */
    public List<OrderedProduct> getOrderedProducts() {
        return data.getOrderedProducts();
    }

    /**
     * Recuperează un produs comandat după ID-ul său.
     *
     * @param id ID-ul produsului comandat de recuperat.
     * @return Obiectul produsului comandat corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    public OrderedProduct getOrderedProductById(int id) {
        return data.getOrderedProductById(id);
    }

    /**
     * Șterge un produs comandat din sistem după ID-ul său.
     *
     * @param id ID-ul produsului comandat de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    public String deleteOrderedProduct(int id) {
        return data.deleteOrderedProduct(id);
    }

    /**
     * Actualizează informațiile unui produs comandat existent.
     *
     * @param orderedProduct Obiectul produsului comandat actualizat.
     * @return Obiectul produsului comandat actualizat, sau null dacă produsul comandat nu a fost găsit.
     */
    public OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct) {
        OrderedProduct existingOrderedProduct = data.getOrderedProductById(orderedProduct.getId());
        if (existingOrderedProduct == null) {
            System.out.println("Produsul comandat nu a fost găsit!");
            return null;
        }
        existingOrderedProduct.setIdOrder(orderedProduct.getIdOrder());
        existingOrderedProduct.setIdProduct(orderedProduct.getIdProduct());
        existingOrderedProduct.setQuantity(orderedProduct.getQuantity());
        return data.updateOrderedProduct(existingOrderedProduct);
    }
}
