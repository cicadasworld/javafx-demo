package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Text text1 = new Text("My TextFlow Layout ");
        text1.setFont(Font.font("Verdana", FontPosture.ITALIC, 48));
        text1.setFill(Color.BLUE);

        TextFlow textFlow = new TextFlow(text1);
        textFlow.setTextAlignment(TextAlignment.CENTER);

        Text text2 = new Text("My FlowPane Layout ");
        text2.setFont(Font.font("Verdana", FontPosture.ITALIC, 48));
        text2.setFill(Color.YELLOW);

        FlowPane flowPane = new FlowPane(text2);
        flowPane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, textFlow, flowPane);
        vBox.setAlignment(Pos.CENTER);
        vBox.setEffect(dropShadow);

        Scene scene = new Scene(vBox, 600, 200, Color.LIGHTGREEN);
        primaryStage.setTitle("TextFlow Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
