package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Color colors[] = {
                Color.ORANGE,
                Color.BLACK,
                Color.RED,
                Color.PINK,
                Color.WHITE,
                Color.GREEN,
                Color.CYAN,
                Color.BLUE
        };
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        TilePane tilePane = new TilePane(Orientation.HORIZONTAL);
        // TilePane tilePane = new TilePane(Orientation.VERTICAL);
        tilePane.setPadding(new Insets(50, 50, 50, 50));
        tilePane.setHgap(25);
        tilePane.setVgap(25);
        tilePane.setAlignment(Pos.CENTER_LEFT);
        // tilePane.setAlignment(Pos.TOP_CENTER);
        tilePane.setEffect(dropShadow);

        for (int i = 0; i < colors.length; i++) {
            if (i < colors.length / 2) {
                Rectangle square = new Rectangle(80, 80, colors[i]);
                square.setArcWidth(30);
                square.setArcHeight(30);
                tilePane.getChildren().add(square);
                continue;
            }
            Circle circle = new Circle(25, colors[i]);
            tilePane.getChildren().add(circle);
        }

        Scene scene = new Scene(tilePane, 420, 400, Color.LIGHTGREEN);
        primaryStage.setTitle("TilePane Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
