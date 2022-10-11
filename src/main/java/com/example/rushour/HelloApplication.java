package com.example.rushour;

import com.example.rushour.controllers.GridController;
import com.example.rushour.model.Grid;
import com.example.rushour.model.Orientation;
import com.example.rushour.model.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.HashSet;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grid.fxml"));
        GridController controller = new GridController(createGrid());
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setScene(scene);
        stage.show();
    }

    private Grid createGrid() {
        Grid grid = new Grid();
        grid.setWidth(5);
        grid.setHeight(5);
        grid.setExit(new Point(5, 2));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.EAST, new Point(1, 2)),
                new Vehicle(2, 2, Orientation.EAST, new Point(1, 4)),
                new Vehicle(3, 3, Orientation.EAST, new Point(4, 4)),
                //new Vehicle(2, 2, Orientation.WEST, new Point(6, 6)),
                new Vehicle(4, 2, Orientation.NORTH, new Point(3, 3)),
                new Vehicle(5, 3, Orientation.WEST, new Point(1, 0))
        )));
        return grid;
    }

    private Grid createGridlevel40() {
        Grid grid = new Grid();
        grid.setWidth(6);
        grid.setHeight(6);
        grid.setExit(new Point(6, 3));
        grid.setVehicles(new HashSet<>(List.of(
                new Vehicle(1, 2, Orientation.EAST, new Point(2, 3)),
                new Vehicle(2, 3, Orientation.SOUTH, new Point(0, 0)),
                new Vehicle(3, 2, Orientation.EAST, new Point(2, 0)),
                new Vehicle(4, 2, Orientation.SOUTH, new Point(1, 1)),
                new Vehicle(5, 2, Orientation.SOUTH, new Point(2, 1)),
                new Vehicle(6, 2, Orientation.SOUTH, new Point(3, 0)),
                new Vehicle(7, 2, Orientation.EAST, new Point(5, 0)),
                new Vehicle(8, 2, Orientation.EAST, new Point(5, 1)),
                new Vehicle(9, 3, Orientation.EAST, new Point(5, 2)),
                new Vehicle(10, 2, Orientation.SOUTH, new Point(2, 4)),
                new Vehicle(11, 2, Orientation.EAST, new Point(4, 5)),
                new Vehicle(13, 2, Orientation.SOUTH, new Point(4, 3)),
                new Vehicle(12, 3, Orientation.NORTH, new Point(5, 5))






                )));
        return grid;
    }

    public static void main(String[] args) {
        launch();
    }
}