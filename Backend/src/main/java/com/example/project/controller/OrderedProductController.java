package com.example.project.controller;

import com.example.project.entity.OrderedProduct;
import com.example.project.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderedProductController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private OrderedProductService service;

    /**
     * Adauga un produs comandat in baza de date.
     * @param orderedProduct produsul comandat care urmeaza sa fie adaugat
     * @return OrderedProduct
     */
    @PostMapping("/addOrderedProduct")
    public OrderedProduct addOrderedProduct(@RequestBody OrderedProduct orderedProduct){
        return service.saveOrderedProduct(orderedProduct);
    }
    /**
     * Adauga mai multe produse comandate in baza de date.
     * @param orderedProducts lista cu produsele comandate care urmeaza sa fie adaugate
     * @return lista produselor comandate adaugate
     */
    @PostMapping("/addOrderedProducts")
    public List<OrderedProduct> addOrderedProducts(@RequestBody List<OrderedProduct> orderedProducts){
        return service.saveOrderedProducts(orderedProducts);
    }
    /**
     * Cauta toate produsele comandate in baza de date.
     * @return lista produselor comandate gasite
     */
    @GetMapping("/orderedProducts")
    public List<OrderedProduct> findAllOrderedProducts(){
        return service.getOrderedProducts();
    }
    /**
     * Cauta un produs comandat dupa id-ul dat.
     * @param id id-ul produsului comandat care urmeaza sa fie cautat
     * @return produsul comandat gasit
     */
    @GetMapping("/orderedProduct/{id}")
    public OrderedProduct findOrderedProductById(@PathVariable int id){
        return service.getOrderedProductById(id);
    }
    /**
     * Actualizeaza un anumit produs comandat.
     * @param orderedProduct produsul comandat care urmeaza sa fie actualizat
     * @return produsul comandat actualizat
     */
    @PutMapping("/updateOrderedProduct")
    public OrderedProduct updateOrderedProduct(@RequestBody OrderedProduct orderedProduct){
        return service.updateOrderedProduct(orderedProduct);
    }
    /**
     * Sterge un anumit produs comandat.
     * @param id id-ul produsului comandat care urmeaza sa fie stears
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteOrderedProduct/{id}")
    public String deleteOrderedProduct(@PathVariable int id){
        return service.deleteOrderedProduct(id);
    }
}
