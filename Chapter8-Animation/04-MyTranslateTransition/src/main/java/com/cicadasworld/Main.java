package com.cicadasworld;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int sceneWidth = 400;
        final int sceneHeight = 200;

        TranslateTransition circleTransition =
                MyCircle.build(Color.CHARTREUSE, sceneWidth - 100, 0.0);

        Button startPauseButton = new Button("Start");
        startPauseButton.setPrefWidth(80);
        startPauseButton.setOnAction(event -> {
            if (circleTransition.getStatus() == Animation.Status.RUNNING) {
                circleTransition.pause();
            } else {
                circleTransition.play();
            }
        });

        startPauseButton.textProperty().bind(
                new When(circleTransition.statusProperty()
                        .isEqualTo(Animation.Status.RUNNING))
                        .then("Pause").otherwise("Start"));

        HBox hBox = new HBox(startPauseButton);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(40, circleTransition.getNode(), hBox);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(40, 20, 20, 20));
        vBox.setStyle("-fx-background-color: linear-gradient(aliceblue, lightblue);");

        Scene scene = new Scene(vBox, sceneWidth, sceneHeight);
        primaryStage.setTitle("Translate Transition");

        scene.widthProperty().addListener(observable -> {
            Animation.Status status = circleTransition.getStatus();
            circleTransition.stop();
            circleTransition.setToX(scene.getWidth() - 100.0);
            if (status == Animation.Status.RUNNING) {
                circleTransition.play();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
