package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        PerspectiveTransform perspective = new PerspectiveTransform();
        perspective.setUlx(50); perspective.setUly(100);
        perspective.setLlx(50); perspective.setLly(175);
        perspective.setUrx(400);perspective.setUry(50);
        perspective.setLrx(400);perspective.setLry(250);

        Rectangle rectangle = new Rectangle(100, 20, 305, 100);
        rectangle.setFill(Color.DARKBLUE);

        Text text = new Text(120, 80, "Announcing!");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        text.setFill(Color.RED);

        root.getChildren().addAll(rectangle, text);
        root.setEffect(perspective);

        Scene scene = new Scene(root, 450, 300, Color.LIGHTYELLOW);
        primaryStage.setTitle("Perspective Transform Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
