package org.example.ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSlot> parkingSlots = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isAvailable() && slot.getSlotType().name().equals(vehicleType.name())) {
                return slot;
            }
        }
        return null; // No available slot found
    }

}
