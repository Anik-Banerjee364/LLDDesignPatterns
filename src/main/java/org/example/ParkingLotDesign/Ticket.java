package org.example.ParkingLotDesign;

import java.util.UUID;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private long entryTime;
    private long exitTime;

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = System.currentTimeMillis();
    }

    public void closeTicket() {
        this.exitTime = System.currentTimeMillis();
    }

    public long getDuration() {
        return exitTime - entryTime;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
