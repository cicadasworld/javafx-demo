package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private final Color colors[] = {
            Color.ORANGE,
            Color.BLACK,
            Color.RED,
            Color.PINK,
            Color.WHITE,
            Color.GREEN,
            Color.CYAN,
            Color.BLUE
    };

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        firstHBox(hBox1, 5);

        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);
        secondHBox(hBox2, 4);

        VBox vBox = new VBox(20, hBox1, hBox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setEffect(dropShadow);

        Scene scene = new Scene(vBox, 400, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("HBoxVBox Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void firstHBox(HBox hBox, int count) {
        for (int i = 0; i < count; i++) {
            Rectangle square = new Rectangle(60, 60, colors[i]);
            square.setArcWidth(30);
            square.setArcHeight(30);
            hBox.getChildren().add(square);
        }
    }

    private void secondHBox(HBox hBox, int count) {
        for (int i = 0; i < count; i++) {
            if (i % 2 != 0) {
                Circle circle = new Circle(30, colors[i + 3]);
                hBox.getChildren().add(circle);
                continue;
            }
            Rectangle rectangle = new Rectangle(95, 60, colors[i + 3]);
            rectangle.setArcWidth(30);
            rectangle.setArcHeight(30);
            hBox.getChildren().add(rectangle);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
