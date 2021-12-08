package com.example.projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Kalkulator liczb zespolonych");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        ((ControllerMain)loader.getController()).init(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}