package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int sliderLength = 50;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Show Some Progress");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Slider slider = new Slider(0, sliderLength, 0);
        ProgressBar bar = new ProgressBar(0);
        ProgressIndicator indicator = new ProgressIndicator(0);

        HBox hBox = new HBox(40, slider, bar, indicator);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setEffect(dropShadow);

        VBox vBox = new VBox(40, label, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setTitle("ProgressBar, ProgressIndicator Controls");

        bar.progressProperty().bind(slider.valueProperty().divide(sliderLength));
        indicator.progressProperty().bind(slider.valueProperty().divide(sliderLength));
        //indicator.progressProperty().bind(bar.progressProperty());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
