package org.example.ParkingLotDesign;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    public Vehicle vehicle;

    public ParkingSlot(String slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
        System.out.println("Vehicle removed from slot " + slotId);
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
