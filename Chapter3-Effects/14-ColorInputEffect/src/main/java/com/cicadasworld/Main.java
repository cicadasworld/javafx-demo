package com.cicadasworld;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        ColorInput colorInput = new ColorInput(70, 70, 160, 160, Color.STEELBLUE);

        Blend blend = new Blend(BlendMode.COLOR_BURN);
        blend.setTopInput(colorInput);

        LinearGradient linearGradient = new LinearGradient(
                0,
                0,
                0.25,
                .25,
                true,
                CycleMethod.REFLECT,
                new Stop(0.0, Color.LIGHTSTEELBLUE),
                new Stop(1.0, Color.PALEGREEN)
        );

        Circle circle = new Circle(150, 150, 75, linearGradient);

        Text text = new Text(100, 150, "COLOR\nINPUT");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        text.setFill(Color.VIOLET);

        root.getChildren().addAll(circle, text);
        root.setEffect(blend);

        Scene scene = new Scene(root, 300, 300, Color.LIGHTYELLOW);
        primaryStage.setTitle("ColorInput Effect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
