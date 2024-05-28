package com.example.project.serviceTests;

import com.example.project.data.ReviewData;
import com.example.project.service.ReviewService;
import com.example.project.serviceimp.ReviewServiceImp;
import com.example.project.entity.Review;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceImpTests {

    @Mock
    private ReviewData data;

    private ReviewService reviewService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewServiceImp(data);
    }

    @Test
    public void testSaveReview(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review = new Review(10, 10, 10, 5, "Bun", calendar.getTime());

        reviewService.saveReview(review);

        Mockito.verify(data).saveReview(review);
    }

    @Test
    public void testSaveReviews(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review1 = new Review(10, 10, 10, 5, "Bun", calendar.getTime());
        Review review2 = new Review(11, 11, 11, 4, "Aproape bun", calendar.getTime());
        List<Review> reviews = List.of(review1, review2);

        reviewService.saveReviews(reviews);

        Mockito.verify(data).saveReviews(reviews);
    }

    @Test
    public void testGetReviews(){
        reviewService.getReviews();

        Mockito.verify(data).getReviews();
    }

    @Test
    public void testGetReviewById(){
        int id = 10;

        reviewService.getReviewById(id);

        Mockito.verify(data).getReviewById(id);
    }

    @Test
    public void testDeleteReview(){
        int id = 10;

        reviewService.deleteReview(id);

        Mockito.verify(data).deleteReview(id);
    }

    @Test
    public void testUpdateReview(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review = new Review(10, 10, 10, 5, "Bun", calendar.getTime());
        when(data.getReviewById(review.getId())).thenReturn(review);

        reviewService.updateReview(review);

        Mockito.verify(data).updateReview(review);
    }

}
