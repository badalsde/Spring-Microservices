package com.rating.repository;

import com.rating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RatingRepository extends MongoRepository<Rating,String> {
    public Optional<Rating> findById(String ratingId);
}
