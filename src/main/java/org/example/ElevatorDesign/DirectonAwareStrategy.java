package org.example.ElevatorDesign;

import java.util.List;

public class DirectonAwareStrategy implements DispatchStrategy{

    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Direction requestDirection = request.getDirection();
        int requestFloor = request.getFloor();

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.getState() == ElevatorState.MAINTENANCE) {
                continue; // Skip elevators under maintenance
            }

            int distance = Math.abs(elevator.getCurrentFloor() - requestFloor);

            if (elevator.getState() == ElevatorState.IDLE) {
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            } else if ((elevator.getState() == ElevatorState.MOVING_UP && requestDirection == Direction.UP) ||
                       (elevator.getState() == ElevatorState.MOVING_DOWN && requestDirection == Direction.DOWN)) {
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
            else {
                // Elevator is moving in opposite direction, consider only if no better option
                if (bestElevator == null && distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        return bestElevator;
    }
}
