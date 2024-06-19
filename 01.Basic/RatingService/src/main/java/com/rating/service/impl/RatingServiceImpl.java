package com.rating.service.impl;

import com.rating.dto.RatingDTO;
import com.rating.entity.Rating;
import com.rating.exception.RatingException;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void saveRating(RatingDTO ratingDTO) {
        String ratingId = UUID.randomUUID().toString();
        ratingDTO.setRatingId(ratingId);
        Rating rating = RatingDTO.toEntity(ratingDTO);
        ratingRepository.save(rating);
    }

    @Override
    public RatingDTO getRating(String id) throws RatingException {
        Optional<Rating> optionalRating = ratingRepository.findById(Integer.valueOf(id));
        Rating rating= optionalRating.orElseThrow(()->new RatingException("Could not find"));
        return RatingDTO.toDTO(rating);
    }

    @Override
    public List<RatingDTO> getAllRating() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList.stream().map(RatingDTO::toDTO).collect(Collectors.toList());
    }
}
