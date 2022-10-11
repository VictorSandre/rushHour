package com.example.rushour.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class GridTest {

    @Nested
    class IsMoveForwardPossibleTests {
        @Test
        void isMoveForwardPossible_WhenWallOnNorth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(8, 8));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenCarOnNorth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.WEST, new Point(0, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(7, 7));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenExitOnNorth_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 9));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(8, 8));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isTrue();
        }

        @Test
        void isMoveForwardPossible_WhenWallOnSouth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 0));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenCarOnSouth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.WEST, new Point(0, 0))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(1, 1));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenExitOnSouth_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(0, -1));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(0, 0));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isTrue();
        }

        @Test
        void isMoveForwardPossible_WhenWallOnEast_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(8, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenCarOnEast_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.NORTH, new Point(8, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(7, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenExitOnEast_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(9, 3));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(8, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isTrue();
        }

        @Test
        void isMoveForwardPossible_WhenWallOnWest_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(0, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenCarOnWest_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.NORTH, new Point(0, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(1, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isFalse();
        }

        @Test
        void isMoveForwardPossible_WhenExitOnWest_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(-1, 3));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(0, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isTrue();
        }

        @ParameterizedTest(name = "isMoveForwardPossible_WhenNothingOn{0}_ExpectTrue")
        @EnumSource(Orientation.class)
        void isMoveForwardPossible_WhenNothingForward_ExpectTrue(Orientation orientation) {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 9));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, orientation, new Point(3, 3));

            //When
            boolean isMoveForwardPossible = grid.isMoveForwardPossible(vehicle);

            //Then
            assertThat(isMoveForwardPossible).isTrue();
        }

    }

    @Nested
    class IsMoveBackwardPossibleTests {
        @Test
        void isMoveBackwardPossible_WhenWallAfterTailOnNorth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(7, 7));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenCarAfterTailOnNorth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.WEST, new Point(0, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(6, 6));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenExitAfterTailOnNorth_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 9));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.SOUTH, new Point(8, 7));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isTrue();
        }

        @Test
        void isMoveBackwardPossible_WhenWallAfterTailOnSouth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(1, 1));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenCarAfterTailOnSouth_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.WEST, new Point(0, 0))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(2, 2));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenExitAfterTailOnSouth_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(0, -1));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.NORTH, new Point(0, 1));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isTrue();
        }

        @Test
        void isMoveBackwardPossible_WhenWallAfterTailOnEast_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(7, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenCarAfterTailOnEast_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.NORTH, new Point(8, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(6, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenExitAfterTailOnEast_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(9, 3));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.WEST, new Point(7, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isTrue();
        }

        @Test
        void isMoveBackwardPossible_WhenWallAfterTailOnWest_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(1, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenCarOnAfterTailWest_ExpectFalse() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 4));
            grid.setVehicles(new HashSet<>(Arrays.asList(
                    new Vehicle(1, 8, Orientation.NORTH, new Point(0, 8))
            )));
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(2, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isFalse();
        }

        @Test
        void isMoveBackwardPossible_WhenExitAfterTailOnWest_ExpectTrue() {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(-1, 3));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, Orientation.EAST, new Point(1, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isTrue();
        }

        @ParameterizedTest(name = "isMoveBackwardPossible_WhenNothingOn{0}_ExpectTrue")
        @EnumSource(Orientation.class)
        void isMoveBackwardPossible_WhenNothingBackward_ExpectTrue(Orientation orientation) {
            //Given
            Grid grid = new Grid();
            grid.setWidth(9);
            grid.setHeight(9);
            grid.setExit(new Point(8, 9));
            grid.setVehicles(new HashSet<>());
            Vehicle vehicle = new Vehicle(1, 2, orientation, new Point(3, 3));

            //When
            boolean isMoveBackwardPossible = grid.isMoveBackwardPossible(vehicle);

            //Then
            assertThat(isMoveBackwardPossible).isTrue();
        }
    }

}