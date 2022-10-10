package com.example.rushour.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ObjectInputFilter;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationTest {

    @Test
    public void generateNeighbours_When1CarWith2PossibleMoves_Expect2Neighbours() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(9);
        grid.setHeight(9);
        grid.setExit(new Point(8, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.SOUTH, new Point(3, 3))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        configuration.generateNeighbours();

        //Then
        assertThat(configuration.generateNeighbours().size()).isEqualTo(2);
    }

    @Test
    public void generateNeighbours_When1CarWith1PossibleMoves_Expect1Neighbours() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(9);
        grid.setHeight(9);
        grid.setExit(new Point(8, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 0))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        HashSet<Configuration> neighbours = configuration.generateNeighbours();

        //Then
        assertThat(neighbours.size()).isEqualTo(1);
    }

    @Test
    public void generateNeighbours_When1CarWith0PossibleMoves_Expect0Neighbours() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(2);
        grid.setHeight(2);
        grid.setExit(new Point(8, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 0))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        configuration.generateNeighbours();

        //Then
        assertThat(configuration.generateNeighbours().size()).isEqualTo(0);
    }

    @Test
    public void isSolution_WhenNoVehicleOnExit_ReturnFalse() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(2);
        grid.setHeight(2);
        grid.setExit(new Point(8, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 0))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        boolean actualIsSolution = configuration.isSolution();

        //Then
        assertThat(actualIsSolution).isFalse();
    }

    @Test
    public void isSolution_WhenVehicleExitOnTail_ReturnTrue() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(2);
        grid.setHeight(2);
        grid.setExit(new Point(0, 2));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 1))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        boolean actualIsSolution = configuration.isSolution();

        //Then
        assertThat(actualIsSolution).isTrue();
    }

    @Test
    public void isSolution_WhenVehicleExitOnHead_ReturnTrue() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(2);
        grid.setHeight(2);
        grid.setExit(new Point(0, 2));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.NORTH, new Point(0, 2))
        )));
        Configuration configuration = new Configuration(grid);

        //When
        boolean actualIsSolution = configuration.isSolution();

        //Then
        assertThat(actualIsSolution).isTrue();
    }
}