package com.rating.dto;

import com.rating.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {
    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;

    //Convert Entity to DTO
    public static RatingDTO toDTO(Rating rating){
        RatingDTO ratingDTO=new RatingDTO();
        ratingDTO.setRatingId(rating.getRatingId());
        ratingDTO.setUserId(rating.getUserId());
        ratingDTO.setHotelId(rating.getHotelId());
        ratingDTO.setRating(rating.getRating());
        ratingDTO.setFeedback(rating.getFeedback());
        return ratingDTO;
    }

    //Convert DTO to Entity
    public static Rating toEntity(RatingDTO ratingDTO){
        Rating rating=new Rating();
        rating.setRatingId(ratingDTO.getRatingId());
        rating.setUserId(ratingDTO.getUserId());
        rating.setHotelId(ratingDTO.getHotelId());
        rating.setRating(ratingDTO.getRating());
        rating.setFeedback(ratingDTO.getFeedback());
        return rating;
    }
}
