package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
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

        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);

        Circle circle = new Circle(50, Color.BLUE);

        Rectangle square = new Rectangle(100, 100, Color.RED);
        square.setArcWidth(30);
        square.setArcHeight(30);

        hBox.getChildren().addAll(circle, square);
        hBox.setEffect(dropShadow);

        Scene scene = new Scene(hBox, 400, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("HBox Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
