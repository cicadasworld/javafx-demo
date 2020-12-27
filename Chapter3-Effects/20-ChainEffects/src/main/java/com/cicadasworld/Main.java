package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Reflection reflection = new Reflection();
        reflection.setFraction(.8);
        reflection.setTopOpacity(.8);
        reflection.setBottomOpacity(.2);

        PerspectiveTransform perspective = new PerspectiveTransform();
        perspective.setUlx(50); perspective.setUly(10);
        perspective.setLlx(50); perspective.setLly(550);
        perspective.setUrx(400);perspective.setUry(50);
        perspective.setLrx(400);perspective.setLry(450);
        perspective.setInput(reflection);

        ImageView imageView = new ImageView("trees.jpg");
        imageView.setEffect(perspective);

        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 450, 560, Color.LIGHTGRAY);
        primaryStage.setTitle("Chaining Effects");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
