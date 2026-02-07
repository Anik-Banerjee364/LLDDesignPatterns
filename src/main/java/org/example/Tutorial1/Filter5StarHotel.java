package org.example.Tutorial1;

public class Filter5StarHotel implements FilteringCondition {

    @Override
    public boolean test(Hotel hotel) {
        if (hotel == null) {
            return false;
        }
        return hotel.getType() == HotelType.FIVE_STAR;
    }
}
