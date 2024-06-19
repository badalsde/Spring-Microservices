package com.hotel.dto;

import com.hotel.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private String id;
    private String name;
    private String location;
    private String about;

    //Entity to HotelDTO
    public static HotelDTO toDTO(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setLocation(hotel.getLocation());
        hotelDTO.setAbout(hotel.getAbout());
        return hotelDTO;
    }

    //HotelDTO to Entity
    public static Hotel toEntity(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setId(hotelDTO.getId());
        hotel.setName(hotelDTO.getName());
        hotel.setLocation(hotelDTO.getLocation());
        hotel.setAbout(hotelDTO.getAbout());
        return hotel;
    }

}
