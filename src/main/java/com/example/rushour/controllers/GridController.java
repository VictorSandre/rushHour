package com.example.rushour.controllers;

import com.example.rushour.model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

public class GridController {

    private Grid grid;
    private HashMap<Integer, Color> vehicleColors;
    @FXML
    private VBox rows;

    private ConfigurationGraph graph;
    private ArrayDeque<Pair<Integer, Integer>> solution;
    private int currentConfigurationId = 0;

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    protected void initGrid() {
        for (int y = grid.getHeight() ; y >= -1; y--) {
            HBox line = new HBox();
            for (int x = -1 ; x < grid.getWidth() + 1 ; x++) {
                Rectangle rectangle = new Rectangle(30,30);
                //TODO refactoring pour rendre le code plus propre
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                if (x == -1 || x == grid.getWidth()  || y == -1 || y == grid.getHeight()) {
                    rectangle.setFill(Color.GRAY);
                }
                if (x == grid.getExit().getX() && y == grid.getExit().getY()) {
                    rectangle.setFill(Color.WHITE);
                }
                line.getChildren().add(rectangle);
            }
            rows.getChildren().add(line);
        }
    }

    protected void initVehicles () {
        for (Vehicle vehicle : grid.getVehicles()) {
            for (Point vehicleCell : vehicle.getVehicleCells()) {
                Rectangle rectangle = (Rectangle) ((HBox) rows.getChildren().get(grid.getHeight() - (int)vehicleCell.getY()))
                        .getChildren().get((int) vehicleCell.getX()+1);
                rectangle.setFill(vehicleColors.get(vehicle.getId()));
            }
        }
    }

    public GridController(Grid grid) throws Exception {
        vehicleColors = new HashMap<>();
        this.setGrid(grid);
        graph = new ConfigurationGraph(new Configuration(grid));
        graph.generateGraph();
        GraphResolver graphResolver = new GraphResolver(graph);
        graphResolver.resolveGraph();
        solution = graphResolver.getSolutionFromAlgorithm();
        this.initVehicleColors();
    }

    private void initVehicleColors() {
        for (Vehicle vehicle: grid.getVehicles()) {
            Random rand = new Random();
            Color randomColor = Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            vehicleColors.put(vehicle.getId(), randomColor);
        }
    }

    @FXML
    private void initialize() {
        this.initGrid();
        this.initVehicles();
    }

    @FXML
    private void onClickNextConfiguration(ActionEvent event) {
        for (Pair<Integer,Integer> nodeId_previousNodeId : solution) {
            if (nodeId_previousNodeId.getValue() == currentConfigurationId && nodeId_previousNodeId.getKey() != currentConfigurationId) {
                System.out.println("currentnodeid:: " + currentConfigurationId);
                System.out.println(graph.getNodeById(nodeId_previousNodeId.getKey()).get().getGrid());
                Grid nextMoveGrid = graph.getNodeById(nodeId_previousNodeId.getKey()).get().getGrid();
                this.setGrid(nextMoveGrid);
                currentConfigurationId = nodeId_previousNodeId.getKey();
                rows.getChildren().clear();
                this.initialize();
                break;
            }
        }
        /*for (Pair pair: solution) {
            System.out.println("toto::"+ pair.getKey() + ", " + pair.getValue());
        }*/
    }

}
