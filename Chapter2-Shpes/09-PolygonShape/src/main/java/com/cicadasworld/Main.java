package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Polygon stopSign = new Polygon(
                new double[] {
                        175.0, 45.0, 225.0, 45.0,
                        265.0, 75.0, 265.0, 125.0,
                        225.0, 155.0, 175.0, 155.0,
                        135.0, 125.0, 135.0, 75.0
                });
        stopSign.setFill(Color.RED);
        stopSign.setStroke(Color.WHITE);
        stopSign.setStrokeWidth(4);

        Text stop = new Text(142, 117, "STOP");
        stop.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        stop.setFill(Color.WHITE);

        root.getChildren().addAll(stopSign, stop);

        Scene scene = new Scene(root, 400, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("Polygon Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
