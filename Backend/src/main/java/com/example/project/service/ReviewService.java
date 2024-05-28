package com.example.project.service;

import com.example.project.entity.Review;

import java.util.List;

public interface ReviewService {

    Review saveReview(Review review);
    List<Review> saveReviews(List<Review> reviews);
    Review getReviewById(int id);
    List<Review> getReviews();
    Review updateReview(Review review);
    String deleteReview(int id);
}
