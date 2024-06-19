package com.rating.repository;

import com.rating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating,Integer> {
}
