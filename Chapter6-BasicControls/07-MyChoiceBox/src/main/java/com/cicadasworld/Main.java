package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Select a Font");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        ChoiceBox<Font> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(
                Font.font("Tahoma", FontWeight.BOLD, 25),
                Font.font("Verdana", FontWeight.BOLD, 25),
                Font.font("Cambria", FontWeight.BOLD, 25)
        );
        choiceBox.getSelectionModel().selectFirst();
        choiceBox.setEffect(dropShadow);
        //choiceBox.setValue(Font.font("Verdana", FontWeight.BOLD, 25));

        HBox choices = new HBox(40, label, choiceBox);
        choices.setAlignment(Pos.CENTER);

        Text text = new Text("Here is some text to view");
        text.fontProperty().bind(choiceBox.valueProperty());

        VBox vBox = new VBox(40, text, choices);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vBox, 500, 300);
        primaryStage.setTitle("ChoiceBox Control");

        choiceBox.setConverter(new StringConverter<Font>() {
            @Override
            public String toString(Font font) {
                return font.getFamily();
            }

            @Override
            public Font fromString(String string) {
                return Font.font(string, FontWeight.BOLD, 25);
            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
