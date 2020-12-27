package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Light.Distant distantLight = new Light.Distant();
        distantLight.setAzimuth(225);

        Lighting lighting = new Lighting(distantLight);
        lighting.setSurfaceScale(5);

        Text text = new Text(50, 110, "Distant Light");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        text.setFill(Color.DODGERBLUE);
        text.setEffect(lighting);

        Rectangle rectangle = new Rectangle(25, 50, 450, 80);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setEffect(lighting);

        root.getChildren().addAll(rectangle, text);

        Scene scene = new Scene(root, 500, 200, Color.LIGHTYELLOW);
        primaryStage.setTitle("Distant Light Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
