package com.example.rushour.model;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GraphResolverTest {

    @Test
    public void resolveGraph_WithSimpleGraph() throws Exception {
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
        GraphResolver resolver = new GraphResolver(graph);
        resolver.resolveGraph();

        ArrayDeque<Pair<Integer, Integer>> expectedSolution = new ArrayDeque<>();
        expectedSolution.addLast(new Pair<>(0,0));
        expectedSolution.addLast(new Pair<>(1,0));
        expectedSolution.addLast(new Pair<>(3,1));

        //When
        ArrayDeque<Pair<Integer, Integer>> actualSolution = resolver.getSolutionFromAlgorithm();

        //Then
        assertThat(actualSolution).containsAll(expectedSolution);
    }

    @Test
    public void resolveGraph_WithMediumGraph() throws Exception {
        //Given
        Grid grid = new Grid();
        grid.setWidth(5);
        grid.setHeight(5);
        grid.setExit(new Point(5, 2));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.EAST, new Point(1, 2)),
                new Vehicle(2, 2, Orientation.EAST, new Point(1, 4)),
                new Vehicle(3, 3, Orientation.EAST, new Point(4, 4)),
                new Vehicle(4, 2, Orientation.NORTH, new Point(3, 3)),
                new Vehicle(5, 3, Orientation.WEST, new Point(1, 0))
        )));
        Configuration configuration = new Configuration(grid);
        ConfigurationGraph graph = new ConfigurationGraph(configuration);
        graph.generateGraph();
        GraphResolver resolver = new GraphResolver(graph);
        resolver.resolveGraph();

        //When
        ArrayDeque<Pair<Integer, Integer>> actualSolution = resolver.getSolutionFromAlgorithm();


        /*for (Configuration conf : graph.getNodes()) {
            System.out.println("id: " + conf.getId());
            System.out.println(conf.getGrid());
        }
        for (Pair<Integer, Integer> link : graph.getNodesLinks()) {
            System.out.println("lien : " + link.getKey() + ", " + link.getValue());
        }
        for (Pair pair: actualSolution) {
            System.out.println("toto::"+ pair.getKey() + ", " + pair.getValue());
        }*/

    }

}