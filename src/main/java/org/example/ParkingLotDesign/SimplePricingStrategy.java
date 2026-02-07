package org.example.ParkingLotDesign;

public class SimplePricingStrategy implements PricingStrategy {
    private static final double CAR_RATE = 2.0; // $2 per hour
    private static final double BIKE_RATE = 1.0; // $1 per hour
    private static final double TRUCK_RATE = 3.0; // $3 per hour

    @Override
    public double calculatePrice(Vehicle vehicle, long hoursParked) {
        switch (vehicle.getType()) {
            case CAR:
                return hoursParked * CAR_RATE;
            case BIKE:
                return hoursParked * BIKE_RATE;
            case TRUCK:
                return hoursParked * TRUCK_RATE;
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
