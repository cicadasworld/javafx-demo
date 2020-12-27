package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private VBox vBox = new VBox(40);

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Change Background Color");
        label.setFont(Font.font("Tahma", FontWeight.BOLD, 16));

        Button yellowButton = makeButton("Yellow");
        Button cyanButton = makeButton("Cyan");
        yellowButton.setDefaultButton(true);
        cyanButton.setCancelButton(true);

        HBox buttons = new HBox(40, yellowButton, cyanButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setEffect(dropShadow);

        vBox.setStyle("-fx-background-color: palegreen");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, buttons);

        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setTitle("Button Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button makeButton(String colorName) {
        Button button = new Button(colorName);
        button.setOnAction(event -> vBox.setStyle("-fx-background-color: " + colorName));
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
