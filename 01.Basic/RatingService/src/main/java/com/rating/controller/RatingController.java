package com.rating.controller;

import com.rating.dto.RatingDTO;
import com.rating.exception.RatingException;
import com.rating.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;

    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.saveRating(ratingDTO);
        String msg = "Rating saved successfully "+ ratingDTO.getRatingId();
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDTO> getRating(@PathVariable String id) throws RatingException {
        RatingDTO ratingDTO = ratingService.getRating(id);
        return new ResponseEntity<RatingDTO>(ratingDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RatingDTO>> getAllRating() {
        List<RatingDTO> ratingDTO = ratingService.getAllRating();
        return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
    }
}
