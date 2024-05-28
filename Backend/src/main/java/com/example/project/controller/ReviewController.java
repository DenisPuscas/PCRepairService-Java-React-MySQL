package com.example.project.controller;

import com.example.project.entity.Review;
import com.example.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private ReviewService service;

    /**
     * Adauga o recenzie in baza de date.
     * @param review recenzia care urmeaza sa fie adaugata
     * @return recenzia adaugata
     */
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return service.saveReview(review);
    }
    /**
     * Adauga mai multe recenzii in baza de date.
     * @param reviews lista cu recenziile care urmeaza sa fie adaugate
     * @return lista recenziilor adaugate
     */
    @PostMapping("/addReviews")
    public List<Review> addReviews(@RequestBody List<Review> reviews){
        return service.saveReviews(reviews);
    }
    /**
     * Cauta toate recenziile in baza de date.
     * @return lista recenziilor gasite
     */
    @GetMapping("/reviews")
    public List<Review> findAllReviews(){
        return service.getReviews();
    }
    /**
     * Cauta o recenzie dupa id-ul dat.
     * @param id id-ul recenziei care urmeaza sa fie cautata
     * @return recenzia gasita
     */
    @GetMapping("/review/{id}")
    public Review findReviewById(@PathVariable int id){
        return service.getReviewById(id);
    }
    /**
     * Actualizeaza un anumit produs.
     * @param review recenzia care urmeaza sa fie actualizata
     * @return recenzia actualizata
     */
    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review review){
        return service.updateReview(review);
    }
    /**
     * Sterge o anumita recenzie.
     * @param id id-ul recenziei care urmeaza sa fie stearsa
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable int id){
        return service.deleteReview(id);
    }
}
