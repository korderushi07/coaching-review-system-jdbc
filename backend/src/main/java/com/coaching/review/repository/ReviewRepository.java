package com.coaching.review.repository;

import com.coaching.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCoachingName(String coachingName);
}