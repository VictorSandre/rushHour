package com.example.rushour.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {

    @Test
    void moveForward_WhenMove1ToNorth_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(0,0));

        //When
        vehicle.moveForward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(0, 1));
    }

    @Test
    void moveForward_WhenMove1ToSouth_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(0,0));

        //When
        vehicle.moveForward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(0, -1));
    }

    @Test
    void moveForward_WhenMove1ToWest_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(0,0));

        //When
        vehicle.moveForward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(-1, 0));
    }

    @Test
    void moveForward_WhenMove1ToEast_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(0,0));

        //When
        vehicle.moveForward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(1, 0));
    }

    @Test
    void moveBackward_WhenMove1ToNorth_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(0,0));

        //When
        vehicle.moveBackward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(0, -1));
    }

    @Test
    void moveBackward_WhenMove1ToSouth_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(0,0));

        //When
        vehicle.moveBackward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(0, 1));
    }

    @Test
    void moveBackward_WhenMove1ToWest_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(0,0));

        //When
        vehicle.moveBackward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(1, 0));
    }

    @Test
    void moveBackward_WhenMove1ToEast_VehicleHeadPositionChanged() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(0,0));

        //When
        vehicle.moveBackward(1);

        //Then
        assertThat(vehicle.getHeadPosition().getLocation())
                .isEqualTo(new Point(-1, 0));
    }

    @Test
    void getVehicleCells_WithNorthOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 3, Orientation.NORTH, new Point(0,0));
        List<Point> expectedList = List.of(new Point(0,0), new Point(0,-1), new Point(0,-2));

        //When
        List<Point> vehicleCells = vehicle.getVehicleCells();

        //Then
        assertThat(vehicleCells).isEqualTo((expectedList));
    }

    @Test
    void getVehicleCells_WithSouthOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 3, Orientation.SOUTH, new Point(0,0));
        List<Point> expectedList = List.of(new Point(0,0), new Point(0,1), new Point(0,2));

        //When
        List<Point> vehicleCells = vehicle.getVehicleCells();

        //Then
        assertThat(vehicleCells).isEqualTo((expectedList));
    }

    @Test
    void getVehicleCells_WithEastOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 3, Orientation.EAST, new Point(0,0));
        List<Point> expectedList = List.of(new Point(0,0), new Point(-1,0), new Point(-2,0));

        //When
        List<Point> vehicleCells = vehicle.getVehicleCells();

        //Then
        assertThat(vehicleCells).isEqualTo((expectedList));
    }

    @Test
    void getVehicleCells_WithWestOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 3, Orientation.WEST, new Point(0,0));
        List<Point> expectedList = List.of(new Point(0,0), new Point(1,0), new Point(2,0));

        //When
        List<Point> vehicleCells = vehicle.getVehicleCells();

        //Then
        assertThat(vehicleCells).isEqualTo((expectedList));
    }

    @Test
    public void getTail_WithNorthOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(0,0));
        Point expectedPosition = new Point(0,-1);

        //When
        Point tailPosition = vehicle.getTail();

        //Then
        assertThat(tailPosition).isEqualTo(expectedPosition);
    }

    @Test
    public void getTail_WithSouthOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(0,0));
        Point expectedPosition = new Point(0,1);

        //When
        Point tailPosition = vehicle.getTail();

        //Then
        assertThat(tailPosition).isEqualTo(expectedPosition);
    }

    @Test
    public void getTail_WithEastOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(0,0));
        Point expectedPosition = new Point(-1,0);

        //When
        Point tailPosition = vehicle.getTail();

        //Then
        assertThat(tailPosition).isEqualTo(expectedPosition);
    }

    @Test
    public void getTail_WithWestOrientation_ReturnExpected() {
        //Given
        Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(0,0));
        Point expectedPosition = new Point(1,0);

        //When
        Point tailPosition = vehicle.getTail();

        //Then
        assertThat(tailPosition).isEqualTo(expectedPosition);
    }
}