package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(-0.05);
        colorAdjust.setContrast(0.1);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);

        Image image = new Image("trees.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(425);
        imageView.setPreserveRatio(true);
        imageView.setEffect(colorAdjust);

        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 425, 280);
        primaryStage.setTitle("ColorAdjust Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
