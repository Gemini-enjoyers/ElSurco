package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Review;
import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getById(Integer id);
    Review create(Review review);
    Review update(Integer id, Review review);
    void delete(Integer id);
}