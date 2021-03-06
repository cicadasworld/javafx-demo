package com.cicadasworld;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.setOnFinished(event -> System.out.println("2 seconds elapsed"));

        Button pauseButton = new Button("Pause 2 seconds");
        pauseButton.setOnAction(event -> pauseTransition.play());

        pauseButton.disableProperty().bind(pauseTransition.statusProperty()
                .isEqualTo(Animation.Status.RUNNING));
        StackPane stackPane = new StackPane(pauseButton);
        stackPane.setPrefHeight(200);
        stackPane.setPrefWidth(400);
        stackPane.setStyle("-fx-background-color: lightblue");

        Scene scene = new Scene(stackPane, 400, 300);
        primaryStage.setTitle("Pause Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
