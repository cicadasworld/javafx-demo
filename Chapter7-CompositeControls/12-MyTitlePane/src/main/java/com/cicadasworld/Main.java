package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: palegreen");

        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        gridPane.add(nameLabel, 0, 0);

        TextField nameField = new TextField();
        nameField.setMaxWidth(200);
        nameField.setEffect(dropShadow);
        gridPane.add(nameField, 1, 0);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        gridPane.add(passwordLabel, 0, 1);

        TextField passwordField = new TextField();
        passwordField.setMaxWidth(200);
        passwordField.setEffect(dropShadow);
        gridPane.add(passwordField, 1, 1);

        Button login = new Button("Login");
        Button clear = new Button("Clear");
        HBox buttons = new HBox(45, login, clear);
        buttons.setPadding(new Insets(0, 10, 0, 0));
        buttons.setEffect(dropShadow);
        gridPane.add(buttons, 1, 2, 3, 1);

        TitledPane titledPane = new TitledPane("Please Login", gridPane);
        //titledPane.setAnimated(false);
        //titledPane.setCollapsible(false);
        //titledPane.setExpanded(false);
        titledPane.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(titledPane, 400, 230);
        primaryStage.setTitle("TitledPane Control");

        login.setOnAction(event -> {
            String name = nameField.getText();
            String password = passwordField.getText();
            if (!name.isEmpty() && !password.isEmpty()) {
                System.out.println(name + " " + password);
            }
            passwordField.clear();
        });

        clear.setOnAction(event -> {
            nameField.clear();
            passwordField.clear();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
