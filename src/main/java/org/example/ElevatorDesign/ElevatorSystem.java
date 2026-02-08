package org.example.ElevatorDesign;
import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    private List<Elevator> elevators = new ArrayList<>();
    private ElevatorScheduler scheduler;

    public ElevatorSystem(int numElevators, DispatchStrategy dispatchStrategy) {
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
        this.scheduler = new ElevatorScheduler(dispatchStrategy);
    }

    public void handleRequest(Request request) {
        Elevator assignedElevator = scheduler.assignElevator(elevators, request);
        if (assignedElevator != null) {
            assignedElevator.addRequest(request);
            processElevator(assignedElevator);
        } else {
            System.out.println("No available elevator to handle the request at floor " + request.getFloor());
        }
    }

    private void processElevator(Elevator elevator) {
        Request request = elevator.getNextRequest();
        if(request != null) {
            elevator.moveToFloor(request.getFloor());
            System.out.println("Elevator " + elevator.getId() + " has arrived at floor " + request.getFloor());
        }
    }

}
