package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final String myText = "The quick brown fox jumped over the lazy dogs.";

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setHtmlText(myText);
        htmlEditor.setPrefHeight(300);

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        Button button = new Button("HTML Code");
        button.setStyle("-fx-background-color: palegreen");
        button.setOnAction(event -> textArea.setText(htmlEditor.getHtmlText()));

        VBox vBox = new VBox(30, htmlEditor, button, textArea);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #e6e6e6");

        Scene scene = new Scene(vBox, 650, 400);
        primaryStage.setTitle("HTMLEditor Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
