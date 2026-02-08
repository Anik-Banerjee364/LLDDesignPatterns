package org.example.ElevatorDesign;

import java.util.List;

public class ElevatorScheduler {

    private DispatchStrategy dispatchStrategy;

    public ElevatorScheduler(DispatchStrategy dispatchStrategy) {
        this.dispatchStrategy = dispatchStrategy;
    }

    public Elevator assignElevator(List<Elevator> elevators, Request request) {
        return dispatchStrategy.selectElevator(elevators, request);
    }
}
