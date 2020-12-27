package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Circle circle = new Circle(250, 125, 75, Color.GREEN);

        Text text = new Text(200, 135, "Bloom!");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        text.setFill(Color.YELLOW);

        Bloom bloom = new Bloom();
        bloom.setThreshold(.5);
        text.setEffect(bloom);

        root.getChildren().addAll(circle, text);

        Scene scene = new Scene(root, 500, 250, Color.LIGHTYELLOW);
        primaryStage.setTitle("Blend Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
