package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        QuadCurve quadCurve = new QuadCurve();
        quadCurve.setStartX(100);
        quadCurve.setStartY(125);
        quadCurve.setEndX(200);
        quadCurve.setEndY(125);
        quadCurve.setControlX(150);
        quadCurve.setControlY(25);
        quadCurve.setFill(Color.CORAL);
        quadCurve.setStroke(Color.BLUE);

//        CubicCurve cubicCurve = new CubicCurve(
//                300,
//                125,
//                325,
//                -25,
//                450,
//                275,
//                475,
//                125
//        );
        CubicCurve cubicCurve = new CubicCurve();
        cubicCurve.setStartX(300);
        cubicCurve.setStartY(125);
        cubicCurve.setControlX1(325);
        cubicCurve.setControlY1(-25);
        cubicCurve.setControlX2(450);
        cubicCurve.setControlY2(275);
        cubicCurve.setEndX(475);
        cubicCurve.setEndY(125);
        cubicCurve.setFill(Color.CORAL);
        cubicCurve.setStroke(Color.BLUE);

        root.getChildren().addAll(quadCurve, cubicCurve);

        Scene scene = new Scene(root, 550, 250, Color.LIGHTGREEN);
        primaryStage.setTitle("Curve Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
