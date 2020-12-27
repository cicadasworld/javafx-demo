package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.setLevel(.8);

        Image image = new Image("trees.jpg", 425, 340, true, true);
        ImageInput imageInput = new ImageInput(image, 10, 10);
        sepiaTone.setInput(imageInput);
        root.setEffect(sepiaTone);

        Scene scene = new Scene(root, 445, 300);
        primaryStage.setTitle("SepiaTone Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}