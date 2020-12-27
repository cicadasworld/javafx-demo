package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private StackPane stackPane = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Select an Icon");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        Hyperlink firstLink = makeHyperlink("Yellow");
        Hyperlink secondLink = makeHyperlink("Cyan");

        Button clearBtn = new Button("Clear Links");
        clearBtn.setEffect(dropShadow);
        clearBtn.setOnAction(event -> {
            firstLink.setVisited(false);
            secondLink.setVisited(false);
            stackPane.setStyle("-fx-background-color: palegreen");
        });

        VBox vBox = new VBox(10, label, firstLink, secondLink, clearBtn);
        vBox.setAlignment(Pos.CENTER);

        stackPane.setStyle("-fx-background-color: palegreen");
        stackPane.getChildren().add(vBox);

        Scene scene = new Scene(stackPane, 400, 200);
        primaryStage.setTitle("Hyperlink Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Hyperlink makeHyperlink(String colorName) {
        Hyperlink hyperlink = new Hyperlink(colorName);
        hyperlink.setOnAction(event ->
                stackPane.setStyle("-fx-background-color: " + colorName));
        return hyperlink;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
