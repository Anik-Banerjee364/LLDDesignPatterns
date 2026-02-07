### Functional Requirements

- Multiple floors

- Different vehicle types: Car, Bike, Truck

- Parking slots by vehicle type

- Issue ticket when vehicle enters

- Calculate price when vehicle exits

- Free slot when vehicle leaves

### Non-Functional

- Scalable

- Extensible (new vehicle types, pricing rules)

### Entities (LLD mindset)

- ParkingLot

- Floor

- ParkingSlot

- Vehicle

- Ticket

- PricingStrategy

### Relationships

- ParkingLot has-a Floors

- Floor has-a Slots

- Slot has-a Vehicle

- Ticket has-a Vehicle & Slot

- Vehicle is-a (Car, Bike, Truck)