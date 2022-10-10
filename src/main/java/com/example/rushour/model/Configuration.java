package com.example.rushour.model;

import java.util.HashSet;
import java.util.Objects;

public class Configuration {
    private int id;
    private Grid grid;;

    public Configuration(Grid grid) {
        this.grid = new Grid(grid);
    }

    public int getId() {
        return id;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashSet<Configuration> generateNeighbours(){
        HashSet<Configuration> neighbours = new HashSet<>();
        for (Vehicle vehicle : grid.getVehicles()) {
            if (this.grid.isMoveForwardPossible(vehicle)) {
                Vehicle vehicleTmp = new Vehicle(vehicle);
                Grid copy = new Grid(this.grid);
                copy.getVehicles().remove(vehicleTmp);
                vehicleTmp.moveForward(1);
                copy.getVehicles().add(vehicleTmp);
                neighbours.add(new Configuration(copy));
            }
            if (this.grid.isMoveBackwardPossible(vehicle)) {
                Vehicle vehicleTmp = new Vehicle(vehicle);
                Grid copy = new Grid(this.grid);
                copy.getVehicles().remove(vehicleTmp);
                vehicleTmp.moveBackward(1);
                copy.getVehicles().add(vehicleTmp);
                neighbours.add(new Configuration(copy));
            }
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Configuration that = (Configuration) o;
        return Objects.equals(grid, that.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid);
    }

    //Todo change is solution to match only the red car or one car with specific id
    public boolean isSolution() {
        for (Vehicle vehicle : this.grid.getVehicles()) {
            if (vehicle.getVehicleCells().contains(this.grid.getExit().getLocation())) {
                return  true;
            }
        }
        return false;
    }
}
