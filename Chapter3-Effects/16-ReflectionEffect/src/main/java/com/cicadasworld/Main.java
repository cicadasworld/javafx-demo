package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
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

        Reflection reflection = new Reflection();
        reflection.setFraction(.8);
        reflection.setTopOffset(2);
        reflection.setTopOpacity(.5);
        reflection.setBottomOpacity(.2);

        Text text = new Text(100, 100, "My Reflection");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40));
        text.setFill(Color.DARKGREEN);
        text.setEffect(reflection);

        root.getChildren().add(text);

        Scene scene = new Scene(root, 500, 200, Color.LIGHTYELLOW);
        primaryStage.setTitle("Reflection Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
