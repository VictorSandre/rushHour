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
import java.io.IOException;
import java.util.HashSet;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grid.fxml"));
        GridController controller = new GridController(createGrid());
        //controller.setGrid(createGrid());
        fxmlLoader.setController(controller);

        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setScene(scene);


        stage.show();
    }

    private Grid createGrid() {
        HashSet<Vehicle> vehicles = new HashSet<>();
        vehicles.add(new Vehicle(1, 2, Orientation.EAST, new Point(1, 4)));
        vehicles.add(new Vehicle(2, 2, Orientation.WEST, new Point(6, 6)));
        vehicles.add(new Vehicle(3, 3, Orientation.NORTH, new Point(4, 4)));
        vehicles.add(new Vehicle(4, 4, Orientation.WEST, new Point(0, 0)));

        Grid grid = new Grid();
        grid.setWidth(9);
        grid.setHeight(9);
        grid.setExit(new Point(9, 4));
        grid.setVehicles(vehicles);
        return grid;
    }

    public static void main(String[] args) {
        launch();
    }
}