package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Choose a Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(event -> label.setTextFill(colorPicker.getValue()));

        VBox vBox = new VBox(30, label, colorPicker);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #e6e6e6");

        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setTitle("ColorPicker Control");
        //label.textFillProperty().bind(colorPicker.valueProperty());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
