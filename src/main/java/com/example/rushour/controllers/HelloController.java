package com.example.rushour.controllers;

import com.example.rushour.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    ConfigurationGraph graph;

    @FXML
    private GridController gridController;

    public HelloController(Grid grid) {
        this.graph = new ConfigurationGraph(new Configuration(grid));
    }

    @FXML
    protected void onHelloButtonClick() {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}