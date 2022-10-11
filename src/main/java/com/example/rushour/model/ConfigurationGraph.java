package com.example.rushour.model;

import javafx.util.Pair;
import java.util.HashSet;
import java.util.Optional;

public class ConfigurationGraph {
    private final HashSet<Configuration> nodes;
    private final HashSet<Pair<Integer, Integer>> nodesLinks;

    public ConfigurationGraph(Configuration startConfiguration) {
        nodes = new HashSet<>();
        startConfiguration.setId(0);
        nodes.add(startConfiguration);
        nodesLinks = new HashSet<>();
    }

    public HashSet<Configuration> getNodes() {
        return nodes;
    }

    public HashSet<Pair<Integer, Integer>> getNodesLinks() {
        return nodesLinks;
    }

    public void generateGraph() {
        int currentNodeId = 0;
        int nodesMaxId = 0;
        do {
            Configuration currentConfiguration = this.getCurrentConfiguration(currentNodeId);
            HashSet<Configuration> neighbours = currentConfiguration.generateNeighbours();
            for (Configuration neighbour : neighbours) {
                if (neighbour.isSolution()) {
                    neighbour.setId(nodesMaxId + 1);
                    nodes.add(neighbour);
                    nodesLinks.add(new Pair<>(currentConfiguration.getId(), nodesMaxId + 1));
                    return;
                } else {
                    if (nodes.contains(neighbour)) {
                        for (Configuration configuration : this.nodes) {
                            if (configuration.equals(neighbour)) {
                                neighbour.setId(configuration.getId());
                            }
                        }
                    } else {
                        nodesMaxId++;
                        neighbour.setId(nodesMaxId);
                        nodes.add(neighbour);
                    }
                    nodesLinks.add(new Pair(currentConfiguration.getId(), neighbour.getId()));
                }
            }
            currentNodeId++;
        } while (containsNodeWithId(currentNodeId));
    }

    private boolean containsNodeWithId(int id) {
        for (Configuration node : this.nodes) {
            if (node.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSolution() {
        return this.getSolutionNode().isPresent();
    }

    private Configuration getCurrentConfiguration(int currentNodeId) {
         return this.nodes.stream()
                 .filter((configuration) -> configuration.getId() == currentNodeId)
                 .findAny()
                 .get();
    }

    //todo test
    public Optional<Configuration> getNodeById(int id) {
        for (Configuration node: this.nodes) {
            if (node.getId() == id) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    //Todo test
    public Optional<Configuration> getSolutionNode() {
        for (Configuration node : nodes) {
            if (node.isSolution()) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }
}
