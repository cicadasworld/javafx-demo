package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image myImage = new Image("trees.jpg");
        ImageView imageView = new ImageView(myImage);
        imageView.setPreserveRatio(true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(imageView);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 450, 350);
        primaryStage.setTitle("ScrollPane Control");

        scrollPane.vvalueProperty().addListener(((observable, oldValue, newValue) ->
                System.out.println(newValue)));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
