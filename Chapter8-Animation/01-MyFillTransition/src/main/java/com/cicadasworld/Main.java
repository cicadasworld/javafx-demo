package com.cicadasworld;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
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
        final Color startColor = Color.ORANGE;
        final Color endColor = Color.LIGHTGREEN;

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.GRAY);

        Rectangle rectangle = new Rectangle(200, 100, startColor);
        rectangle.setStrokeWidth(5);
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);
        rectangle.setStroke(Color.DARKGOLDENROD);
        rectangle.setEffect(dropShadow);

        Text text = new Text("My Rectangle");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        text.setEffect(new Reflection());

        StackPane stackPane = new StackPane(rectangle, text);
        stackPane.setPrefHeight(200);
        stackPane.setPrefWidth(400);

        FillTransition fillTransition =
                new FillTransition(Duration.seconds(2), rectangle);

        fillTransition.setOnFinished(event ->
                System.out.println("End fill color = " +
                        fillTransition.getShape().getFill()));

        Button fillButton = new Button("Fill");
        fillButton.setOnAction(event -> {
            if (fillTransition.getShape().getFill().equals(startColor)) {
                fillTransition.setToValue(endColor);
            } else {
                fillTransition.setToValue(startColor);
            }
            fillTransition.playFromStart();
        });

        fillButton.disableProperty()
                .bind(fillTransition.statusProperty()
                        .isEqualTo(Animation.Status.RUNNING));

        VBox vBox = new VBox(stackPane, fillButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: lightblue");

        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Fill Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
