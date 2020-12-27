package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Circle red = new Circle(250, 150, 50, Color.rgb(255, 0, 0, 1.0));
        Circle green = new Circle(200, 100, 50, Color.rgb(0, 255, 0, 0.5));
        Circle blue = new Circle(300, 100, 50, Color.rgb(0, 0, 255, 0.5));

        Blend blend = new Blend();
        blend.setMode(BlendMode.ADD);

        root.getChildren().addAll(red, green, blue);
        root.setEffect(blend);

        Scene scene = new Scene(root, 500, 250, Color.LIGHTYELLOW);
        primaryStage.setTitle("Blend Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
