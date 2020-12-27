package com.cicadasworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load components from FXML file
        Parent root = FXMLLoader.load(getClass().getResource("HelloJavaFX.fxml"));

        // Create Scene with background color
        Scene scene = new Scene(root, 500, 250, Color.LIGHTYELLOW);

        // Set scene on stage with title
        primaryStage.setTitle("Hello JavaFXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
