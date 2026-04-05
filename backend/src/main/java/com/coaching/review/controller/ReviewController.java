package com.coaching.review.controller;

import com.coaching.review.model.Review;
import com.coaching.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    ReviewRepository repo;

    @GetMapping
    public List<Review> getAll() { return repo.findAll(); }

    @PostMapping
    public Review addReview(@RequestBody Review review) { return repo.save(review); }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review updated) {
        Review existing = repo.findById(id).orElseThrow();
        existing.setRating(updated.getRating());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) { repo.deleteById(id); }

    @GetMapping("/search")
    public List<Review> search(@RequestParam String name) {
        return repo.findByCoachingName(name);
    }
}