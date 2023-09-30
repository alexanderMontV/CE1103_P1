package com.interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("grafica.fxml"));

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Connect Dots CE1103-P1");
        stage.setScene(scene);
        stage.show();

        Circle prime = (Circle) root.lookup("#id00");
        prime.setFill(Paint.valueOf("#FF0000"));



    }
}