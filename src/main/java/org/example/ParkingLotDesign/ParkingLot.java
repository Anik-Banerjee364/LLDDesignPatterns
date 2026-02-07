package org.example.ParkingLotDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private List<Floor> floors = new ArrayList<>();
    private Map<String, Ticket> activeTickets = new HashMap<>();
    private PricingStrategy pricingStrategy;

    public ParkingLot(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle.getType());
            if (slot != null) {
                slot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle, slot);
                activeTickets.put(ticket.getId(), ticket);
                return ticket;
            }
        }
        System.out.println("No available slots for vehicle type: " + vehicle.getType());
        return null; // No available slot found
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            ticket.closeTicket();
            ParkingSlot slot = ticket.getParkingSlot();
            slot.removeVehicle();
            long duration = ticket.getDuration();
            double fee = pricingStrategy.calculatePrice(ticket.getVehicle(), duration);
            activeTickets.remove(ticketId);
            return fee;
        }
        System.out.println("Invalid ticket ID: " + ticketId);
        return 0; // Invalid ticket
    }
}
