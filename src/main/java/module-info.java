module com.example.rushour {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.rushour.controllers to javafx.fxml;
    exports com.example.rushour;
    exports com.example.rushour.controllers;
}