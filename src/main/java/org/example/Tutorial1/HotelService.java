package org.example.Tutorial1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HotelService {

    List<Hotel> hotels = new ArrayList<>();

    public HotelService() {
        // Initialize with some hotels
        hotels.add(new Hotel(10000, 4, HotelType.FIVE_STAR));
        hotels.add(new Hotel(2000, 3, HotelType.FOUR_STAR));
        hotels.add(new Hotel(1500, 4, HotelType.THREE_STAR));
        hotels.add(new Hotel(50000, 5, HotelType.FIVE_STAR));
    }
//
//    private boolean isHotelLessThan(Hotel hotel, int price) {
//        return hotel.getPricePerNight() <= price;
//    }
//
//    public List<Hotel> filterHotelsLessThan(int price) {
//        List<Hotel> filteredHotels = new ArrayList<>();
//        for (Hotel hotel : hotels) {
//            if (isHotelLessThan(hotel, price)) {
//                filteredHotels.add(hotel);
//            }
//        }
//        return filteredHotels;
//    }

//    private boolean isHotel5Star(Hotel hotel) {
//        return hotel.getType() == HotelType.FIVE_STAR;
//    }

    public List<Hotel> filterHotels(Predicate<Hotel> condition) {
        List<Hotel> filteredHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (condition.test(hotel)) {
                filteredHotels.add(hotel);
            }
        }
        return filteredHotels;
    }


}
