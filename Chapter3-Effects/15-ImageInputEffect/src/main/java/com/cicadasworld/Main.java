package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Image image = new Image("trees.jpg", 425, 280, true, true);
        ImageInput imageInput = new ImageInput(image, 10, 10);

        GaussianBlur gaussianBlur = new GaussianBlur(3);
        gaussianBlur.setInput(imageInput);

        root.setEffect(gaussianBlur);

        Scene scene = new Scene(root, 425, 280);
        primaryStage.setTitle("ImageInput Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
