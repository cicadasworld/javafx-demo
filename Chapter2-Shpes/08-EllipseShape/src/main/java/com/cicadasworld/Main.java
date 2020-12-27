package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(300);
        ellipse.setCenterY(100);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(75);
        ellipse.setFill(Color.CORAL);
        ellipse.setStroke(Color.BLUE);
        ellipse.setStrokeWidth(2);
        root.getChildren().add(ellipse);

        Scene scene = new Scene(root, 600, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("Ellipse Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
