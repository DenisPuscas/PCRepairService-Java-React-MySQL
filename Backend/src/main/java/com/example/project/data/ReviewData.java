package com.example.project.data;

import com.example.project.entity.Review;

import java.util.List;

public interface ReviewData {

    Review saveReview(Review review);
    List<Review> saveReviews(List<Review> reviews);
    List<Review> getReviews();
    Review getReviewById(int id);
    String deleteReview(int id);
    Review updateReview(Review review);
}
