package org.example.ElevatorDesign;

import javax.swing.plaf.nimbus.State;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Elevator {

    private int id;
    private int currentFloor;
    private ElevatorState state;
    private Direction direction;

    private Queue<Request> requestQueue = new ConcurrentLinkedQueue<>();

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assuming ground floor
        this.state = ElevatorState.IDLE;
        this.direction = Direction.NONE;
    }

    public synchronized void addRequest(Request request) {
        requestQueue.offer(request);
    }

    public synchronized Request getNextRequest() {
        return requestQueue.poll();
    }

    public boolean isIdle() {
        return state == ElevatorState.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int floor) {
        if (floor > currentFloor) {
            direction = Direction.UP;
            state = ElevatorState.MOVING_UP;
        } else if (floor < currentFloor) {
            direction = Direction.DOWN;
            state = ElevatorState.MOVING_DOWN;
        } else {
            direction = Direction.NONE;
            state = ElevatorState.IDLE;
        }
        // Simulate movement
        currentFloor = floor;
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }
}
