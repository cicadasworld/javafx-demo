package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Text text = new Text(50, 100, "Here's a Text String");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 50));
        text.setStroke(Color.LIGHTSALMON);
        text.setStrokeWidth(2);
        text.setUnderline(true);

        root.getChildren().add(text);

        Scene scene = new Scene(root, 650, 200, Color.LIGHTYELLOW);
        primaryStage.setTitle("Text Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
