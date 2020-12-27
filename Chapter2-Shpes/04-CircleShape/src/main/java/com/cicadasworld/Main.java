package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        int radius = 40;
        int strokeWidth = 3;
        Color strokeColor = Color.BROWN;
        Group root = new Group();

        Circle circle1 = new Circle(120, 100, radius, Color.CORAL);
        circle1.setStroke(strokeColor);
        circle1.setStrokeWidth(strokeWidth);

        Circle circle2 = new Circle(220, 100, radius, Color.YELLOW);
        circle2.setStroke(strokeColor);
        circle1.setStrokeWidth(strokeWidth);

        Circle circle3 = new Circle(320, 100, radius, Color.PALEGREEN);
        circle3.setStroke(strokeColor);
        circle1.setStrokeWidth(strokeWidth);

        root.getChildren().addAll(circle1, circle2, circle3);

        Scene scene = new Scene(root, 450, 200, Color.LIGHTYELLOW);
        primaryStage.setTitle("Circle Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
