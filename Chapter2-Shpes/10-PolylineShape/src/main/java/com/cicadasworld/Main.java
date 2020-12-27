package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Polyline polyline = new Polyline(new double[] {
                175.0, 45.0, 225.0, 45.0,
                265.0, 75.0, 265.0, 125.0,
                225.0, 155.0, 175.0, 155.0,
                135.0, 125.0, 135.0, 75.0, 175.0, 45.0
        });
        polyline.setFill(Color.CORAL);
        polyline.setStroke(Color.BLUE);
        polyline.setStrokeWidth(6);

        root.getChildren().add(polyline);

        Scene scene = new Scene(root, 400, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("Polyline Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
