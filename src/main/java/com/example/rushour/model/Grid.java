package com.example.rushour.model;

import java.awt.Point;

import java.util.HashSet;
import java.util.Objects;

public class Grid {
    private HashSet<Vehicle> vehicles;
    private int height;
    private int width;
    private Point exit;

    public Grid() {}

    public Grid(Grid grid) {
        this.vehicles = new HashSet<>(grid.vehicles);
        this.height = grid.height;
        this.width = grid.width;
        this.exit = grid.exit;
    }

    public HashSet<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashSet<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getExit() {
        return exit;
    }

    public void setExit(Point exit) {
        this.exit = exit;
    }

    public boolean isMoveForwardPossible(Vehicle vehicle) {
        Vehicle vehicleTmp = new Vehicle(vehicle);
        vehicleTmp.moveForward(1);
        Point vehicleHead = vehicleTmp.getHeadPosition();
        return !(this.isPartOfVehicle(vehicleHead) || this.isWall(vehicleHead));
    }

    public boolean isMoveBackwardPossible(Vehicle vehicle) {
        Vehicle vehicleTmp = new Vehicle(vehicle);
        vehicleTmp.moveBackward(1);
        Point vehicleTail = vehicleTmp.getTail();
        return !(this.isPartOfVehicle(vehicleTail) || this.isWall(vehicleTail));
    }

    private boolean isWall(Point cell) {
        if (cell.equals(this.exit)) {
            return false;
        }
        if (cell.getX() == -1 || cell.getX() == this.width) {
            return true;
        }
        return (cell.getY() == -1 || cell.getY() == this.height);
    }

    private boolean isPartOfVehicle(Point cell) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVehicleCells().contains(cell)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        for (int y=this.height-1 ; y>-1 ; --y) {
            for (int x=0 ; x<this.width ; ++x) {
                toPrint.append(getCurrentCellValueAsString(new Point(x, y)));
            }
            toPrint.append('\n');
        }
        return toPrint.append("\n+++++++++++++++++++++++++++\n").toString();
    }

    private String getCurrentCellValueAsString(Point currentCell) {
        if (currentCell.equals(this.exit)) {
            return "x";
        }
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVehicleCells().contains(currentCell)) {
                /*if (currentCell.equals(vehicle.getHeadPosition()))
                    return "h";*/
                return Integer.toString(vehicle.getId());
            }
        }
        return "0";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return height == grid.height && width == grid.width && vehicles.equals(grid.vehicles) && Objects.equals(exit, grid.exit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicles);
    }
}
