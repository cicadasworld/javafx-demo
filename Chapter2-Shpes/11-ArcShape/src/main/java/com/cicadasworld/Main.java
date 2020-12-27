package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Arc arc1 = createArc(ArcType.ROUND, 80);
        Arc arc2 = createArc(ArcType.CHORD, 200);
        Arc arc3 = createArc(ArcType.OPEN, 320);

        root.getChildren().addAll(arc1, arc2, arc3);

        Scene scene = new Scene(root, 400, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("Arc Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Arc createArc(ArcType arcType, double x) {
        Arc arc = new Arc();
        arc.setCenterX(x);
        arc.setCenterY(100);
        arc.setRadiusX(40);
        arc.setRadiusY(40);
        arc.setStartAngle(45);
        arc.setLength(270);
        arc.setFill(Color.CORAL);
        arc.setStroke(Color.BLUE);
        arc.setType(arcType);
        return arc;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
