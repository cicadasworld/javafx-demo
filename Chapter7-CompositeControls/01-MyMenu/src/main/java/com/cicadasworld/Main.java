package com.cicadasworld;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private final StringProperty currentFont = new SimpleStringProperty("Arial");
    private final StringProperty currentStyle = new SimpleStringProperty("");
    private final StringProperty currentSize = new SimpleStringProperty("18");
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        final String myString = "The quick brown fox jumped over the lazy dogs";

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        TextArea textArea = new TextArea(myString);
        textArea.setWrapText(true);
        textArea.setEffect(dropShadow);

        Menu fontMenu = new Menu("Font");
        MenuItem arial = makeFontMenuItem("Arial", 'R');
        MenuItem calibri = makeFontMenuItem("Calibri", 'B');
        MenuItem cambria = makeFontMenuItem("Cambria", 'M');
        fontMenu.getItems().addAll(arial, calibri, cambria);

        Menu sizeMenu = new Menu("Size");
        RadioMenuItem small = makeRadioMenuItem("18", true);
        RadioMenuItem medium = makeRadioMenuItem("28", false);
        RadioMenuItem large = makeRadioMenuItem("36", false);
        sizeMenu.getItems().addAll(small, medium, large);

        Menu styleMenu = new Menu("Style");
        CheckMenuItem bold = new CheckMenuItem("Bold");
        CheckMenuItem italic = new CheckMenuItem("Italic");
        styleMenu.getItems().addAll(bold, italic);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fontMenu, sizeMenu, styleMenu);

        VBox textVBox = new VBox(20, textArea);
        textVBox.setAlignment(Pos.CENTER);
        textVBox.setPadding(new Insets(30));

        VBox vBox = new VBox(menuBar, textVBox);
        vBox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Menu Control");

        StringBinding styleBinding = new StringBinding() {
            {
                super.bind(bold.selectedProperty(), italic.selectedProperty());
            }
            @Override
            protected String computeValue() {
                StringBuilder style = new StringBuilder();
                if (bold.isSelected()) {
                    style.append("bold ");
                }
                if (italic.isSelected()) {
                    style.append("italic ");
                }
                return style.toString();
            }
        };
        currentStyle.bind(styleBinding);

        textArea.styleProperty().bind(Bindings.concat("-fx-font: ")
                .concat(currentStyle.concat(" "))
                .concat(currentSize).concat("pt ")
                .concat(currentFont.concat(";")));

        //textArea.styleProperty().addListener((observable, oldValue, newValue) ->
        //        System.out.println(newValue));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuItem makeFontMenuItem(String fontName, char accKey) {
        MenuItem menuItem = new MenuItem(fontName);
        menuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+" + accKey));
        menuItem.setOnAction(event -> currentFont.set(menuItem.getText()));
        return menuItem;
    }

    private RadioMenuItem makeRadioMenuItem(String size, boolean selected) {
        RadioMenuItem menuItem = new RadioMenuItem(size);
        if (selected) {
            menuItem.setSelected(true);
            currentSize.set(menuItem.getText());
        }
        menuItem.setToggleGroup(toggleGroup);
        menuItem.setOnAction(event -> currentSize.set(menuItem.getText()));
        return menuItem;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
