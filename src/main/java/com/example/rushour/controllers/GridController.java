package com.example.rushour.controllers;

import com.example.rushour.model.Grid;
import com.example.rushour.model.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

public class GridController {

    private static final int HEIGHT = 9;
    private static final int WIDTH = 9;
    private Grid grid;
    private HashMap<Integer, Color> vehicleColors;
    @FXML
    private VBox rows;

    public void setGrid(Grid grid) {
        this.grid = grid;
        this.initVehicleColors();
    }

    protected void initGrid() {
        for (int y = HEIGHT ; y >= -1; y--) {
            HBox line = new HBox();
            for (int x = -1 ; x < WIDTH + 1 ; x++) {
                Rectangle rectangle = new Rectangle(30,30);
                //TODO refactoring pour rendre le code plus propre
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                if (x == -1 || x == WIDTH  || y == -1 || y == HEIGHT) {
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
                Rectangle rectangle = (Rectangle) ((HBox) rows.getChildren().get(HEIGHT - (int)vehicleCell.getY()))
                        .getChildren().get((int) vehicleCell.getX()+1);
                rectangle.setFill(vehicleColors.get(vehicle.getId()));
            }
        }
    }

    public GridController(Grid grid) {
        vehicleColors = new HashMap<>();
        this.setGrid(grid);
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

}
