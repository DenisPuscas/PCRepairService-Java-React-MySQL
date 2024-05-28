package com.example.project.dataimp;

import com.example.project.data.ReviewData;
import com.example.project.entity.Review;
import com.example.project.repository.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței ReviewData.
 * Ea comunică cu repository-ul ReviewRepository pentru a efectua operații legate de recenzii.
 */
@Component
public class ReviewDataImp implements ReviewData {

    private final ReviewRepository repo;

    /**
     * Construiește o nouă instanță a clasei ReviewDataImp cu ReviewRepository specificat.
     *
     * @param repo Obiectul ReviewRepository care va fi utilizat pentru accesul la date.
     */
    public ReviewDataImp(ReviewRepository repo) {
        this.repo = repo;
    }

    /**
     * Salvează o recenzie în sistem.
     *
     * @param review Obiectul recenziei de salvat.
     * @return Obiectul recenziei salvate.
     */
    @Override
    public Review saveReview(Review review) {
        return repo.save(review);
    }

    /**
     * Salvează o listă de recenzii în sistem.
     *
     * @param reviews Lista obiectelor de recenzii de salvat.
     * @return Lista obiectelor de recenzii salvate.
     */
    @Override
    public List<Review> saveReviews(List<Review> reviews) {
        return repo.saveAll(reviews);
    }

    /**
     * Recuperează toate recenziile din sistem.
     *
     * @return O listă cu toate obiectele de recenzii.
     */
    @Override
    public List<Review> getReviews() {
        return repo.findAll();
    }

    /**
     * Recuperează o recenzie după ID-ul său.
     *
     * @param id ID-ul recenziei de recuperat.
     * @return Obiectul recenziei corespunzător ID-ului furnizat, sau null dacă nu a fost găsită.
     */
    @Override
    public Review getReviewById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Șterge o recenzie din sistem după ID-ul său.
     *
     * @param id ID-ul recenziei de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteReview(int id) {
        repo.deleteById(id);
        return "Review " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unei recenzii existente.
     *
     * @param review Obiectul recenziei actualizate.
     * @return Obiectul recenziei actualizate.
     */
    @Override
    public Review updateReview(Review review) {
        return repo.save(review);
    }
}
