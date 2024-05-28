package com.example.project.dataTests;

import com.example.project.data.ReviewData;
import com.example.project.dataimp.ReviewDataImp;
import com.example.project.entity.Review;
import com.example.project.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
public class ReviewDataImpTests {

    @Mock
    private ReviewRepository repo;

    private ReviewData reviewData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        reviewData = new ReviewDataImp(repo);
    }

    @Test
    public void testSaveReview(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review = new Review(10, 10, 10, 5, "Bun", calendar.getTime());

        reviewData.saveReview(review);

        Mockito.verify(repo).save(review);
    }

    @Test
    public void testSaveReviews(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review1 = new Review(10, 10, 10, 5, "Bun", calendar.getTime());
        Review review2 = new Review(11, 11, 11, 4, "Aproape bun", calendar.getTime());
        List<Review> reviews = List.of(review1, review2);

        reviewData.saveReviews(reviews);

        Mockito.verify(repo).saveAll(reviews);
    }

    @Test
    public void testGetReviews(){
        reviewData.getReviews();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetReviewById(){
        int id = 10;

        reviewData.getReviewById(id);

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void testDeleteReview(){
        int id = 10;

        reviewData.deleteReview(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateReview(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Review review = new Review(10, 10, 10, 5, "Bun", calendar.getTime());

        reviewData.updateReview(review);

        Mockito.verify(repo).save(review);
    }

}
