package com.cicadasworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

        TreeView<String> treeView = MyTree.buildTree();
        treeView.setEffect(dropShadow);

        TextField textField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            TreeItem<String> node = treeView.getSelectionModel().getSelectedItem();
            String team = textField.getText();
            if (node != null && !team.isEmpty()) {
                node.getChildren().add(new TreeItem<>(team));
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            TreeItem<String> node = treeView.getSelectionModel().getSelectedItem();
            if (node.getParent() != null) {
                node.getParent().getChildren().remove(node);
            }
        });

        HBox hBox = new HBox(20, addButton, textField, deleteButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setEffect(dropShadow);

        VBox vBox = new VBox(20, treeView, hBox);
        vBox.setPadding(new Insets(30));
        vBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setTitle("TreeView Control");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
