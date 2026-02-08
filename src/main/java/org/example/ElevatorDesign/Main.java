package org.example.ElevatorDesign;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(3, new DirectonAwareStrategy());

        // Simulate some requests
        elevatorSystem.handleRequest(new Request(1, Direction.UP, RequestType.EXTERNAL));
        elevatorSystem.handleRequest(new Request(5, Direction.DOWN, RequestType.EXTERNAL));
        elevatorSystem.handleRequest(new Request(2, Direction.NONE, RequestType.INTERNAL));
    }
}
