package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Find Your Puzzles");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        label.setUnderline(true);
        label.setTextFill(Color.NAVY);
        label.setGraphic(new ImageView(new Image("cube.png")));
        label.setWrapText(true); // 文字折行
        label.setContentDisplay(ContentDisplay.TOP);
        label.setTextAlignment(TextAlignment.CENTER);

        StackPane stackPane = new StackPane(label);
        stackPane.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(stackPane, 400, 200);
        primaryStage.setTitle("Label Control");

        label.opacityProperty().bind(
                scene.widthProperty().add(scene.heightProperty()).divide(1000));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
