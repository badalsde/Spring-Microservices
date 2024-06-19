package com.rating.service;

import com.rating.dto.RatingDTO;
import com.rating.exception.RatingException;

import java.util.List;

public interface RatingService {
    public void saveRating(RatingDTO ratingDTO);
    public RatingDTO getRating(String id) throws RatingException;
    public List<RatingDTO> getAllRating();
}
