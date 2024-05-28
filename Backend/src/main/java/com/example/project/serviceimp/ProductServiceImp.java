package com.example.project.serviceimp;

import com.example.project.data.ProductData;
import com.example.project.entity.Product;
import com.example.project.enumeration.Category;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței ProductService.
 * Ea comunică cu stratul de date ProductData pentru a efectua operații legate de produse.
 */
@Service
public class ProductServiceImp implements ProductService {

    private final ProductData data;

    /**
     * Construiește o nouă instanță a clasei ProductServiceImp cu ProductData specificat.
     *
     * @param data Obiectul ProductData care va fi utilizat pentru accesul la date.
     */
    public ProductServiceImp(ProductData data) {
        this.data = data;
    }

    /**
     * Salvează un produs în sistem.
     *
     * @param product Obiectul produsului de salvat.
     * @return Obiectul produsului salvat.
     */
    public Product saveProduct(Product product) {
        return data.saveProduct(product);
    }

    /**
     * Salvează o listă de produse în sistem.
     *
     * @param products Lista obiectelor de produse de salvat.
     * @return Lista obiectelor de produse salvate.
     */
    public List<Product> saveProducts(List<Product> products) {
        return data.saveProducts(products);
    }

    /**
     * Recuperează toate produsele din sistem.
     *
     * @return O listă cu toate obiectele de produse.
     */
    public List<Product> getProducts() {
        return data.getProducts();
    }

    /**
     * Recuperează un produs după ID-ul său.
     *
     * @param id ID-ul produsului de recuperat.
     * @return Obiectul produsului corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    public Product getProductById(int id) {
        return data.getProductById(id);
    }

    /**
     * Recuperează un produs după numele său.
     *
     * @param name Numele produsului de recuperat.
     * @return Obiectul produsului corespunzător numelui furnizat, sau null dacă nu a fost găsit.
     */
    public List<Product> getProductByName(String name) {
        return data.getProductByName(name);
    }

    public List<Product> getProductByCategory(Category category){
        return data.getProductByCategory(category);
    }

    /**
     * Șterge un produs din sistem după ID-ul său.
     *
     * @param id ID-ul produsului de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    public String deleteProduct(int id) {
        return data.deleteProduct(id);
    }

    /**
     * Actualizează informațiile unui produs existent.
     *
     * @param product Obiectul produsului actualizat.
     * @return Obiectul produsului actualizat, sau null dacă produsul nu a fost găsit.
     */
    public Product updateProduct(Product product) {
        Product existingProduct = data.getProductById(product.getId());
        if (existingProduct == null) {
            System.out.println("Produsul nu a fost găsit!");
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setImage(product.getImage());
        return data.updateProduct(existingProduct);
    }
}
