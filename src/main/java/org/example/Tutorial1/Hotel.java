package org.example.Tutorial1;

public class Hotel {

    public int pricePerNight;
    public int rating;
    public HotelType type;

    public Hotel(int pricePerNight, int rating, HotelType type) {
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.type = type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "pricePerNight=" + pricePerNight +
                ", rating=" + rating +
                ", type=" + type +
                '}';
    }
}
