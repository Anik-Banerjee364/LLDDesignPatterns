package org.example.ParkingLotDesign;

public class Main {
    public static void main(String[] args) {
        PricingStrategy pricingStrategy = new SimplePricingStrategy();
        ParkingLot parkingLot = new ParkingLot(pricingStrategy);
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        floor1.addParkingSlot(new ParkingSlot("1", SlotType.CAR));
        floor1.addParkingSlot(new ParkingSlot("2", SlotType.TRUCK));
        floor2.addParkingSlot(new ParkingSlot("3", SlotType.TRUCK));
        floor2.addParkingSlot(new ParkingSlot("4", SlotType.CAR));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car1 = new Car("ABC123");
        Vehicle truck1 = new Truck("XYZ789");

        Ticket carTicket = parkingLot.parkVehicle(car1);
        System.out.println("Car parked with ticket ID: " + carTicket.getId());

        Ticket truckTicket = parkingLot.parkVehicle(truck1);
        System.out.println("Truck parked with ticket ID: " + truckTicket.getId());

        //delay to simulate parking duration
        try {
            Thread.sleep(2000); // Simulate 2 seconds of parking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //unpark vehicles and calculate fees
        double carFee = parkingLot.unparkVehicle(carTicket.getId());
        System.out.println("Car unparked. Fee: $" + carFee);

        double truckFee = parkingLot.unparkVehicle(truckTicket.getId());
        System.out.println("Truck unparked. Fee: $" + truckFee);

    }
}
