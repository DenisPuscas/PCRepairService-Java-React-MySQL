package com.example.project.controller;

import com.example.project.entity.Product;
import com.example.project.enumeration.Category;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private ProductService service;

    /**
     * Adauga un produs in baza de date.
     * @param product produsul care urmeaza sa fie adaugat
     * @return OrderedProduct
     */
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    /**
     * Adauga mai multe produse in baza de date.
     * @param products lista cu produsele care urmeaza sa fie adaugate
     * @return lista produselor adaugate
     */
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    /**
     * Cauta toate produsele in baza de date.
     * @return lista produselor gasite
     */
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    /**
     * Cauta un produs dupa id-ul dat.
     * @param id id-ul produsului care urmeaza sa fie cautat
     * @return produsul gasit
     */
    @GetMapping("/product/id/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    /**
     * Cauta un produs dupa un nume dat.
     * @param name numele produsului care urmeaza sa fie cautat
     * @return produsul gasit
     */
    @GetMapping("/products/name/{name}")
    public List<Product> findProductsByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @GetMapping("/product/category/{category}")
    public List<Product> getProductByCategory(@PathVariable Category category){
        return service.getProductByCategory(category);
    }
    /**
     * Actualizeaza un anumit produs.
     * @param product produsul care urmeaza sa fie actualizat
     * @return produsul actualizat
     */
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    /**
     * Sterge un anumit produs.
     * @param id id-ul produsului care urmeaza sa fie stears
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
