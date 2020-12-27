package com.cicadasworld;

import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        Label label = new Label("Please Choose a country flag");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Label selection = new Label();
        selection.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        VBox vBox = new VBox(40, label, selection);
        vBox.setAlignment(Pos.CENTER);

        TitledPane pane1 = makeTitlePane("Spain");
        TitledPane pane2 = makeTitlePane("Brazil");
        TitledPane pane3 = makeTitlePane("Italy");
        TitledPane pane4 = makeTitlePane("Portugal");
        TitledPane pane5 = makeTitlePane("Norway");

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(pane1, pane2, pane3, pane4, pane5);
        accordion.setEffect(dropShadow);

        HBox hBox = new HBox(40, vBox, accordion);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(hBox, 600, 300);
        primaryStage.setTitle("Accordion Control");

        StringBinding choiceBinding = new StringBinding() {
            {
                super.bind(accordion.expandedPaneProperty());
            }
            @Override
            protected String computeValue() {
                if (accordion.getExpandedPane() == null) {
                    return "";
                }
                String name = accordion.getExpandedPane().getText();
                return "You chose " + name + " flag";
            }
        };
        selection.textProperty().bind(choiceBinding);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TitledPane makeTitlePane(String country) {
        Image image = new Image(country + ".png");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        return new TitledPane(country, imageView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
