package com.hotel.controller;

import com.hotel.dto.HotelDTO;
import com.hotel.exception.HotelException;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<String> saveHotel(@RequestBody HotelDTO hotelDTO){
       hotelService.createHotel(hotelDTO);
       String msg = "Hotel Created Successfully " + hotelDTO.getId();
       return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable String id) throws HotelException {
        HotelDTO hotelDTO = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        List<HotelDTO> result = hotelService.getAllHotels();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
