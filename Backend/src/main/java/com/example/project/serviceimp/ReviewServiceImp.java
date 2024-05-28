package com.example.project.serviceimp;

import com.example.project.data.ReviewData;
import com.example.project.entity.Review;
import com.example.project.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței ReviewService.
 * Ea comunică cu stratul de date ReviewData pentru a efectua operații legate de recenzii.
 */
@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewData data;

    /**
     * Construiește o nouă instanță a clasei ReviewServiceImp cu ReviewData specificat.
     *
     * @param data Obiectul ReviewData care va fi utilizat pentru accesul la date.
     */
    public ReviewServiceImp(ReviewData data) {
        this.data = data;
    }

    /**
     * Salvează o recenzie în sistem.
     *
     * @param review Obiectul recenziei de salvat.
     * @return Obiectul recenziei salvate.
     */
    public Review saveReview(Review review) {
        return data.saveReview(review);
    }

    /**
     * Salvează o listă de recenzii în sistem.
     *
     * @param reviews Lista obiectelor de recenzii de salvat.
     * @return Lista obiectelor de recenzii salvate.
     */
    public List<Review> saveReviews(List<Review> reviews) {
        return data.saveReviews(reviews);
    }

    /**
     * Recuperează toate recenziile din sistem.
     *
     * @return O listă cu toate obiectele de recenzii.
     */
    public List<Review> getReviews() {
        return data.getReviews();
    }

    /**
     * Recuperează o recenzie după ID-ul său.
     *
     * @param id ID-ul recenziei de recuperat.
     * @return Obiectul recenziei corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    public Review getReviewById(int id) {
        return data.getReviewById(id);
    }

    /**
     * Șterge o recenzie din sistem după ID-ul său.
     *
     * @param id ID-ul recenziei de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    public String deleteReview(int id) {
        return data.deleteReview(id);
    }

    /**
     * Actualizează informațiile unei recenzii existente.
     *
     * @param review Obiectul recenziei actualizat.
     * @return Obiectul recenziei actualizat, sau null dacă recenzia nu a fost găsită.
     */
    public Review updateReview(Review review) {
        Review existingReview = data.getReviewById(review.getId());
        if (existingReview == null) {
            System.out.println("Recenzia nu a fost găsită!");
            return null;
        }
        existingReview.setIdUser(review.getIdUser());
        existingReview.setIdProduct(review.getIdProduct());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setDate(review.getDate());
        return data.updateReview(existingReview);
    }
}
