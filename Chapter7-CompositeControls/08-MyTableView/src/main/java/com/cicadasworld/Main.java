package com.cicadasworld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private final ObservableList<SalesData> data = FXCollections.observableArrayList();

    private void initData() {
        data.setAll(
                new SalesData("Nokia", 77.3),
                new SalesData("RIM", 51.1),
                new SalesData("Apple", 93.2),
                new SalesData("HTC", 43.5),
                new SalesData("SamSung", 94.0),
                new SalesData("Others", 132.3)
        );

    }

    @Override
    public void start(Stage primaryStage) {
        initData();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("SmartPhone Sales");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        VBox vBox = new VBox(label);
        vBox.setAlignment(Pos.CENTER);

        TableColumn<SalesData, String> companyColumn = new TableColumn<>("Company");
        companyColumn.setMinWidth(75);
        companyColumn.setCellValueFactory(cell -> cell.getValue().companyProperty());

        TableColumn<SalesData, Double> unitsColumn = new TableColumn<>("Units Sold");
        unitsColumn.setMinWidth(50);
        unitsColumn.setCellValueFactory(cell -> cell.getValue().unitsProperty().asObject());

        TableView<SalesData> tableView = new TableView<>(data);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setPrefHeight(175);
        tableView.getColumns().add(companyColumn);
        tableView.getColumns().add(unitsColumn);
        tableView.setEffect(dropShadow);

        final TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setEffect(dropShadow);

        textField.setOnAction(event -> {
            try {
                Double units = Double.parseDouble(textField.getText());
                SalesData salesData = tableView.getSelectionModel().getSelectedItem();
                if (salesData != null && units > 0.0) {
                    salesData.setUnits(units);
                }
            } catch (NumberFormatException e) {}
        });

        Button removeButton = new Button("Remove Company");
        removeButton.setEffect(dropShadow);
        removeButton.setOnAction(event -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                data.remove(index);
            }
        });

        Button resetButton = new Button("Reset Table");
        resetButton.setEffect(dropShadow);
        resetButton.setOnAction(event -> initData());

        Label chageLabel = new Label("Change Units Sold");
        chageLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

        HBox hBox = new HBox(20, chageLabel, textField);
        hBox.setAlignment(Pos.CENTER_LEFT);

        VBox mainVBox = new VBox(20, vBox, tableView, hBox, removeButton, resetButton);
        mainVBox.setAlignment(Pos.CENTER_LEFT);
        mainVBox.setPadding(new Insets(20, 30, 30, 30));
        mainVBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(mainVBox, 400, 420);
        primaryStage.setTitle("TableView Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
