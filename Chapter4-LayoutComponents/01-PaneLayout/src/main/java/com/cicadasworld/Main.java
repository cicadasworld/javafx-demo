package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Pane pane = new Pane();
        pane.setPrefWidth(200);
        pane.setPrefWidth(200);

        Circle circle = new Circle(50, Color.BLUE);
        circle.relocate(50, 50);

        Rectangle square = new Rectangle(100, 100, Color.RED);
        square.setArcWidth(30);
        square.setArcHeight(30);
        square.relocate(200, 50);

        pane.getChildren().addAll(circle, square);

        Scene scene = new Scene(pane, 350, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("Pane Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
