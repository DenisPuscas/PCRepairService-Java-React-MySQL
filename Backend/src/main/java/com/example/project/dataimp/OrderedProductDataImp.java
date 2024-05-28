package com.example.project.dataimp;

import com.example.project.data.OrderedProductData;
import com.example.project.entity.OrderedProduct;
import com.example.project.repository.OrderedProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței OrderedProductData.
 * Ea comunică cu repository-ul OrderedProductRepository pentru a efectua operații legate de produsele comandate.
 */
@Component
public class OrderedProductDataImp implements OrderedProductData {

    private final OrderedProductRepository repo;

    /**
     * Construiește o nouă instanță a clasei OrderedProductDataImp cu OrderedProductRepository specificat.
     *
     * @param repo Obiectul OrderedProductRepository care va fi utilizat pentru accesul la date.
     */
    public OrderedProductDataImp(OrderedProductRepository repo) {
        this.repo = repo;
    }

    /**
     * Salvează un produs comandat în sistem.
     *
     * @param orderedProduct Obiectul produsului comandat de salvat.
     * @return Obiectul produsului comandat salvat.
     */
    @Override
    public OrderedProduct saveOrderedProduct(OrderedProduct orderedProduct) {
        return repo.save(orderedProduct);
    }

    /**
     * Salvează o listă de produse comandate în sistem.
     *
     * @param orderedProducts Lista obiectelor de produse comandate de salvat.
     * @return Lista obiectelor de produse comandate salvate.
     */
    @Override
    public List<OrderedProduct> saveOrderedProducts(List<OrderedProduct> orderedProducts) {
        return repo.saveAll(orderedProducts);
    }

    /**
     * Recuperează toate produsele comandate din sistem.
     *
     * @return O listă cu toate obiectele de produse comandate.
     */
    @Override
    public List<OrderedProduct> getOrderedProducts() {
        return repo.findAll();
    }

    /**
     * Recuperează un produs comandat după ID-ul său.
     *
     * @param id ID-ul produsului comandat de recuperat.
     * @return Obiectul produsului comandat corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public OrderedProduct getOrderedProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Șterge un produs comandat din sistem după ID-ul său.
     *
     * @param id ID-ul produsului comandat de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteOrderedProduct(int id) {
        repo.deleteById(id);
        return "OrderedProduct " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unui produs comandat existent.
     *
     * @param orderedProduct Obiectul produsului comandat actualizat.
     * @return Obiectul produsului comandat actualizat.
     */
    @Override
    public OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct) {
        return repo.save(orderedProduct);
    }
}
