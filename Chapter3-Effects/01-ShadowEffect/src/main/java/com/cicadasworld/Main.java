package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Shadow shadow = new Shadow();
        shadow.setRadius(5);

        Text text = new Text(150, 50, "Shadow");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        text.setFill(Color.DARKRED);
        text.setEffect(shadow);

        Circle circle = new Circle(180, 120, 40, Color.DODGERBLUE);
        circle.setEffect(shadow);

        Rectangle rectangle = new Rectangle(260, 80, 80, 80);
        rectangle.setFill(Color.LIGHTGREEN);
        rectangle.setEffect(shadow);

        root.getChildren().addAll(text, circle, rectangle);

        Scene scene = new Scene(root, 500, 200, Color.LIGHTYELLOW);
        primaryStage.setTitle("Shadow Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
