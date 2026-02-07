package org.example.ParkingLotDesign;

public interface PricingStrategy {
    double calculatePrice(Vehicle vehicle, long durationInHours);
}
