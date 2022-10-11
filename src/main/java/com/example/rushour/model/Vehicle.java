package com.example.rushour.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehicle {
    private int id;
    private int size;
    private Orientation orientation;
    private Point headPosition;

    public Vehicle(int id, int size, Orientation orientation, Point headPosition) {
        this.id = id;
        this.size = size;
        this.orientation = orientation;
        this.headPosition = headPosition;
    }

    public Vehicle(Vehicle vehicle) {
        this.id = vehicle.id;
        this.size = vehicle.size;
        this.orientation = vehicle.orientation;
        this.headPosition = vehicle.headPosition.getLocation();
    }

    public int getId() {
        return id;
    }

    public Point getHeadPosition() {
        return headPosition;
    }

    public void moveForward(int numberOfMove) {
        switch (this.orientation) {
            case EAST -> this.headPosition.translate(numberOfMove, 0);
            case WEST -> this.headPosition.translate(-numberOfMove, 0);
            case NORTH -> this.headPosition.translate(0, numberOfMove);
            case SOUTH -> this.headPosition.translate(0, -numberOfMove);
        }
    }

    public void moveBackward(int numberOfMove) {
        this.moveForward(-numberOfMove);
    }

    public Point getTail() {
        Point cellToAdd =  this.headPosition.getLocation();
        int translationToTail = this.size - 1;
        switch (this.orientation) {
            case NORTH -> cellToAdd.translate(0, -translationToTail);
            case SOUTH -> cellToAdd.translate(0, translationToTail);
            case EAST -> cellToAdd.translate(-translationToTail, 0);
            case WEST -> cellToAdd.translate(translationToTail, 0);
        }
        return cellToAdd;
    }

    public List<Point> getVehicleCells() {
        List<Point> vehicleCells = new ArrayList<>();
        vehicleCells.add(this.headPosition.getLocation());
        for (int i=1 ; i<this.size ; ++i) {
            switch (this.orientation) {
                case NORTH -> {
                    Point cellToAdd = this.headPosition.getLocation();
                    cellToAdd.translate(0, -i);
                    vehicleCells.add(cellToAdd);
                }
                case SOUTH -> {
                    Point cellToAdd = this.headPosition.getLocation();
                    cellToAdd.translate(0, i);
                    vehicleCells.add(cellToAdd);
                }
                case EAST -> {
                    Point cellToAdd = this.headPosition.getLocation();
                    cellToAdd.translate(-i, 0);
                    vehicleCells.add(cellToAdd);
                }
                case WEST -> {
                    Point cellToAdd = this.headPosition.getLocation();
                    cellToAdd.translate(i, 0);
                    vehicleCells.add(cellToAdd);
                }
            }
        }
        return vehicleCells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id
                        && size == vehicle.size
                        && orientation == vehicle.orientation
                        && headPosition.equals(vehicle.headPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", size=" + size +
                ", orientation=" + orientation +
                ", headPosition=[" + headPosition.getX() + ", " + headPosition.getY() + "]" +
                '}';
    }
}