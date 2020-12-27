package com.cicadasworld;

import javafx.animation.Animation;
import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Color startColor = Color.DARKGOLDENROD;
        final Color endColor = Color.BROWN;

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.GRAY);

        Rectangle rectangle = new Rectangle(200, 100, Color.ORANGE);
        rectangle.setStrokeWidth(5);
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);
        rectangle.setStroke(startColor);
        rectangle.setEffect(dropShadow);

        Text text = new Text("My Rectangle");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        text.setEffect(new Reflection());

        StackPane stackPane = new StackPane(rectangle, text);
        stackPane.setPrefHeight(200);
        stackPane.setPrefWidth(400);

        StrokeTransition strokeTransition =
                new StrokeTransition(Duration.seconds(2), rectangle);

        strokeTransition.setOnFinished(event ->
                System.out.println("End fill color = " +
                        strokeTransition.getShape().getStroke()));

        Button strokeButton = new Button("Stroke");
        strokeButton.setOnAction(event -> {
            if (strokeTransition.getShape().getStroke().equals(startColor)) {
                strokeTransition.setToValue(endColor);
            } else {
                strokeTransition.setToValue(startColor);
            }
            strokeTransition.playFromStart();
        });

        strokeButton.disableProperty()
                .bind(strokeTransition.statusProperty()
                        .isEqualTo(Animation.Status.RUNNING));

        VBox vBox = new VBox(stackPane, strokeButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: lightblue");

        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Stroke Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
