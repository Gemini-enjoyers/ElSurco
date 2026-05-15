package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Review;
import com.elSurco.ElSurco_in5bv.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Integer id) {
        return reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review with ID " + id + " not found."));
    }

    @Override
    public Review create(Review review) {
        review.setIdReview(null);
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Integer id, Review review) {
        Review existingReview = getById(id);

        // Actualizamos los campos de la reseña
        existingReview.setReviewScore(review.getReviewScore());
        existingReview.setReviewComment(review.getReviewComment());

        // Mantenemos las relaciones actualizadas
        existingReview.setProduct(review.getProduct());
        existingReview.setUser(review.getUser());

        return reviewRepository.save(existingReview);
    }

    @Override
    public void delete(Integer id) {
        Review existingReview = getById(id);
        reviewRepository.delete(existingReview);
    }
}