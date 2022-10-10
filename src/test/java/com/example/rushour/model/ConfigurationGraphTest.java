package com.example.rushour.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationGraphTest {

    @Test
    void generateGraph_WithSimpleSolution_GenerateExpected() {
        //Given
        Grid grid = new Grid();
        grid.setWidth(4);
        grid.setHeight(4);
        grid.setExit(new Point(0, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
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
}