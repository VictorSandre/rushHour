package com.example.rushour.model;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;

public class GraphResolver {
    private final ConfigurationGraph graph;

    private ArrayDeque<Pair<Integer, Integer>> nodesToVisit;

    private ArrayDeque<Pair<Integer, Integer>> visitedNodes;

    public GraphResolver(ConfigurationGraph graph) {
        this.graph = graph;
        nodesToVisit = new ArrayDeque<>();
        visitedNodes = new ArrayDeque<>();
    }

    public ArrayDeque<Pair<Integer, Integer>> resolveGraph () {
        //compute the following only if (graph.hasSolution())
        nodesToVisit.add(new Pair<>(0,0));
        while (!nodesToVisit.isEmpty()) {
            HashSet<Integer> neighboursIds = this.getDistinctNeighboursLinksFromNodeWithId(nodesToVisit.getFirst().getKey());
            for (Integer neighbourId : neighboursIds) {
                if (!alreadyHasBeenVisited(neighbourId)) {
                    this.nodesToVisit.add(new Pair<>(neighbourId, nodesToVisit.getFirst().getKey()));
                }
            }
            Pair<Integer, Integer> visited = this.nodesToVisit.pollFirst();
            visitedNodes.add(visited);
        }

        ArrayDeque<Pair<Integer, Integer>> solution = new ArrayDeque<>();
        Pair<Integer, Integer> visited = visitedNodes.pollLast();
        int precedentNodeIdToSolution = visited.getValue();
        solution.addFirst(visited);
        while (!visitedNodes.isEmpty()) {
            visited = visitedNodes.pollLast();
            if (visited.getKey().equals(precedentNodeIdToSolution)){
                solution.addFirst(visited);
                precedentNodeIdToSolution = visited.getValue();
            }
        }
        return solution;
    }

    private boolean alreadyHasBeenVisited(Integer neighbourId) {
        for (Pair<Integer, Integer> nodeLink : this.visitedNodes) {
            if (nodeLink.getKey().equals(neighbourId)) {
                return true;
            }
        }
        return false;
    }

    HashSet<Integer> getDistinctNeighboursLinksFromNodeWithId(int id) {
        HashSet<Integer> links = new HashSet<>();
        for (Pair<Integer,Integer> link : graph.getNodesLinks()) {
            if (link.getKey() == id && !links.contains(link.getValue())) {
                links.add(link.getValue());
            }
            if (link.getValue() == id && !links.contains(link.getKey())) {
                links.add(link.getKey());
            }
        }
        return links;
    }
}
