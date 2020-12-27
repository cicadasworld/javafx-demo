package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int offsetY = 6;
        final int sceneWidth = 450;
        final int sceneHeight = 350;

        ScrollBar hScroller = new ScrollBar();
        hScroller.setMin(0);
        hScroller.setMax(sceneWidth);
        hScroller.setPrefWidth(sceneWidth);
        //hScroller.setUnitIncrement(50);

        ScrollBar vScroller = new ScrollBar();
        vScroller.setOrientation(Orientation.VERTICAL);
        vScroller.setMin(0);
        vScroller.setMax(sceneHeight);
        vScroller.setPrefHeight(sceneHeight);
        //vScroller.setUnitIncrement(50);
        vScroller.setLayoutY(hScroller.getWidth() - offsetY);

        Image myImage = new Image("trees.jpg");
        ImageView imageView = new ImageView(myImage);
        imageView.setPreserveRatio(true);

        VBox vBox = new VBox(imageView);
        Group root = new Group(vBox, vScroller, hScroller);

        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setTitle("ScrollBar Control");

        vBox.layoutYProperty().bind(vScroller.valueProperty().negate());
        vScroller.prefHeightProperty().bind(scene.heightProperty().subtract(2 * offsetY));

        vBox.layoutXProperty().bind(hScroller.valueProperty().negate());
        hScroller.prefWidthProperty().bind(scene.widthProperty());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
