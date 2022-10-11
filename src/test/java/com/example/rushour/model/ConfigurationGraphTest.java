package com.example.rushour.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationGraphTest {

    @Test
    void generateGraph_WithSimpleSolution_GenerateExpected() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(4);
        grid.setHeight(4);
        grid.setExit(new Point(0, 4));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.NORTH, new Point(0, 2))
        )));
        Configuration configuration = new Configuration(grid);
        ConfigurationGraph graph = new ConfigurationGraph(configuration);

        //When
        graph.generateGraph();

        //Then
        assertThat(graph.getNodes().size()).isEqualTo(4);
        assertThat(graph.getNodesLinks().size()).isEqualTo(3);
    }

    @Test
    void hasSolution_WhenSolutionExists_ReturnTrue() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(4);
        grid.setHeight(4);
        grid.setExit(new Point(0, 4));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.NORTH, new Point(0, 2))
        )));
        Configuration configuration = new Configuration(grid);
        ConfigurationGraph graph = new ConfigurationGraph(configuration);
        graph.generateGraph();

        //When
        boolean hasSolutionExpected = graph.hasSolution();

        //Then
        assertThat(hasSolutionExpected).isTrue();
    }

    @Test
    void hasSolution_WhenSolutionDoNotExists_ReturnFalse() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(4);
        grid.setHeight(4);
        grid.setExit(new Point(1, 4));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.NORTH, new Point(0, 2))
        )));
        Configuration configuration = new Configuration(grid);
        ConfigurationGraph graph = new ConfigurationGraph(configuration);
        graph.generateGraph();

        //When
        boolean hasSolutionExpected = graph.hasSolution();

        //Then
        assertThat(hasSolutionExpected).isFalse();
    }
}