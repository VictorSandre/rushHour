package com.example.rushour.model;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class GraphResolverTest {

    @Test
    public void test() {
        Grid grid = new Grid();
        grid.setWidth(4);
        grid.setHeight(4);
        grid.setExit(new Point(0, 4));
        grid.setVehicles(new HashSet<>(Arrays.asList(
                new Vehicle(1, 2, Orientation.NORTH, new Point(0, 2))
        )));
        Configuration configuration = new Configuration(grid);
        ConfigurationGraph graph = new ConfigurationGraph(configuration);
        GraphResolver resolver = new GraphResolver(graph);
        graph.generateGraph();

        ArrayDeque<Pair<Integer, Integer>> expectedSolution = new ArrayDeque<>();
        expectedSolution.addLast(new Pair<>(0,0));
        expectedSolution.addLast(new Pair<>(1,0));
        expectedSolution.addLast(new Pair<>(3,1));



        //When
        ArrayDeque<Pair<Integer, Integer>> actualSolution = resolver.resolveGraph();

        //Then
        assertThat(actualSolution).containsAll(expectedSolution);
        /*
        for (Configuration conf : graph.getNodes()) {
            System.out.println("id: " + conf.getId());
            System.out.println(conf.getGrid());
        }
        for (Pair<Integer, Integer> link : graph.getNodesLinks()) {
            System.out.println("lien : " + link.getKey() + ", " + link.getValue());
        }
        for (Pair pair: expectedSolution) {
            System.out.println("toto::"+ pair.getKey() + ", " + pair.getValue());
        }
        */
    }

}