package com.hotel.service;

import com.hotel.dto.HotelDTO;
import com.hotel.exception.HotelException;

import java.util.List;

public interface HotelService {
    public void createHotel(HotelDTO hotelDTO);
    public HotelDTO getHotelById(String id) throws HotelException;
    public List<HotelDTO> getAllHotels();
}
