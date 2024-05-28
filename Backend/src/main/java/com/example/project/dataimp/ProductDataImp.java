package com.example.project.dataimp;

import com.example.project.data.ProductData;
import com.example.project.entity.Product;
import com.example.project.enumeration.Category;
import com.example.project.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței ProductData.
 * Ea comunică cu repository-ul ProductRepository pentru a efectua operații legate de produse.
 */
@Component
public class ProductDataImp implements ProductData {

    private final ProductRepository repo;

    /**
     * Construiește o nouă instanță a clasei ProductDataImp cu ProductRepository specificat.
     *
     * @param repo Obiectul ProductRepository care va fi utilizat pentru accesul la date.
     */
    public ProductDataImp(ProductRepository repo) {
        this.repo = repo;
    }

    /**
     * Salvează un produs în sistem.
     *
     * @param product Obiectul produsului de salvat.
     * @return Obiectul produsului salvat.
     */
    @Override
    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    /**
     * Salvează o listă de produse în sistem.
     *
     * @param products Lista obiectelor de produse de salvat.
     * @return Lista obiectelor de produse salvate.
     */
    @Override
    public List<Product> saveProducts(List<Product> products) {
        return repo.saveAll(products);
    }

    /**
     * Recuperează toate produsele din sistem.
     *
     * @return O listă cu toate obiectele de produse.
     */
    @Override
    public List<Product> getProducts() {
        return repo.findAll();
    }

    /**
     * Recuperează un produs după ID-ul său.
     *
     * @param id ID-ul produsului de recuperat.
     * @return Obiectul produsului corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Recuperează un produs după numele său.
     *
     * @param name Numele produsului de recuperat.
     * @return Obiectul produsului corespunzător numelui furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public List<Product> getProductByName(String name) {
        return repo.findByNameLike(name);
    }

    @Override
    public List<Product> getProductByCategory(Category category){
        return repo.findByCategory(category);
    }

    /**
     * Șterge un produs din sistem după ID-ul său.
     *
     * @param id ID-ul produsului de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Product " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unui produs existent.
     *
     * @param product Obiectul produsului actualizat.
     * @return Obiectul produsului actualizat.
     */
    @Override
    public Product updateProduct(Product product) {
        return repo.save(product);
    }
}
