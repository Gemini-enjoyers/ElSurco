package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Review;
import com.elSurco.ElSurco_in5bv.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) { this.reviewService = reviewService; }

    @GetMapping("/getAll")
    public List<Review> getAll() { return reviewService.getAll(); }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Integer id) { return reviewService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Review create(@RequestBody Review review) { return reviewService.create(review); }

    @PutMapping("/update/{id}")
    public Review update(@PathVariable("id") Integer id, @RequestBody Review review) {
        return reviewService.update(id, review);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) { reviewService.delete(id); }
}