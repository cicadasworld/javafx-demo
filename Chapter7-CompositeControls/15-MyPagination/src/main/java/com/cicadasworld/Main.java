package com.cicadasworld;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private final int itemCount = 15;
    private final String[] colors = getColors();
    private final int lastPage = colors.length / itemCount;
    private final int remainder =
            colors.length - colors.length / itemCount * itemCount;

    @Override
    public void start(Stage primaryStage) {
        Pagination pagination = new Pagination(lastPage + (remainder != 0 ? 1 : 0));
        pagination.setPrefWidth(300);
        pagination.setPageFactory(pageIndex -> createPage(pageIndex));

        HBox hBox = new HBox(pagination);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20));
        Scene scene = new Scene(hBox, 400, 420);

        primaryStage.setTitle("Pagination Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String[] getColors() {
        List<String> list = new ArrayList<>();
        Field[] fields = Color.class.getFields();
        for (Field field : fields) {
            String colorName = field.getName();
            list.add(colorName);
        }
        return list.toArray(new String[list.size()]);
    }

    private Node createPage(Integer pageIndex) {
        VBox vBox = new VBox(5);
        int page = pageIndex * itemCount;
        int maxItem = page + (pageIndex == lastPage ? remainder : itemCount);
        for (int i = page; i < maxItem; i++) {
            Label colorName = new Label(colors[i]);
            Rectangle colorSquare = new Rectangle(15, 15, Color.web(colors[i]));
            HBox hBox = new HBox(5, colorSquare, colorName);
            vBox.getChildren().add(hBox);
        }
        return vBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
