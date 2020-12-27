package com.cicadasworld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        ObservableList<String> leftList =
                FXCollections.observableArrayList("Red", "Green",
                        "Blue", "Yellow", "Orange", "Purple",
                        "Violet", "Brown", "Black", "White");

        ListView<String> leftListView = new ListView<>(leftList);
        leftListView.setMaxWidth(300);
        leftListView.setMaxHeight(300);
        leftListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        leftListView.setEffect(dropShadow);

        ObservableList<String> rightList = FXCollections.observableArrayList();

        ListView<String> rightListView = new ListView<>(rightList);
        rightListView.setMaxWidth(300);
        rightListView.setMaxHeight(300);
        rightListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        rightListView.setEffect(dropShadow);

        Button leftButton = new Button("<-");
        Button rightButton = new Button("->");

        VBox vBox = new VBox(20, rightButton, leftButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinWidth(40);
        vBox.setEffect(dropShadow);

        HBox hBox = new HBox(20, leftListView, vBox, rightListView);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20));
        hBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(hBox, 400, 300);
        primaryStage.setTitle("ListView Control");

        rightButton.setOnAction(event -> {
            ObservableList<String> selections =
                    FXCollections.observableArrayList(
                            leftListView.getSelectionModel().getSelectedItems());
            leftList.removeAll(selections);
            rightList.addAll(selections);
        });

        leftButton.setOnAction(event -> {
            ObservableList<String> selections =
                    FXCollections.observableArrayList(
                            rightListView.getSelectionModel().getSelectedItems());
            rightList.removeAll(selections);
            leftList.addAll(selections);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
