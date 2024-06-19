package com.hotel.service.impl;

import com.hotel.dto.HotelDTO;
import com.hotel.entity.Hotel;
import com.hotel.exception.HotelException;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void createHotel(HotelDTO hotelDTO) {
//        String tempId =UUID.randomUUID().toString();
//        hotelDTO.setId(tempId);
        System.out.println(hotelDTO);
        hotelRepository.save(HotelDTO.toEntity(hotelDTO));
    }

    @Override
    public HotelDTO getHotelById(String id) throws HotelException {
        Optional<Hotel> optionalHotel = hotelRepository.findById(Integer.valueOf(id));
        Hotel hotel = optionalHotel.orElseThrow(()->new HotelException());
        return HotelDTO.toDTO(hotel);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelDTO> hotelDTOS = new ArrayList<>();
        for(Hotel hotel:hotelList){
            hotelDTOS.add(HotelDTO.toDTO(hotel));
        }
        return hotelDTOS;
    }
}
