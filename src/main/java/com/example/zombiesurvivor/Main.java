package com.example.zombiesurvivor;

import com.example.zombiesurvivor.modele.Environnement;
import com.example.zombiesurvivor.modele.Joueur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
    private Environnement env = new Environnement();
    private ParallelCamera camera;

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load(Main.class.getResource("vue1.fxml"));
            Scene scene = new Scene(root,960,640);
            primaryStage.setScene(scene);
            primaryStage.show();
            root.requestFocus();
//            camera = new ParallelCamera();
//            scene.setCamera(camera);
//            camera.layoutXProperty().bind(env.getPersonage().Xproperty().subtract(scene.getWidth()/2));
//            camera.layoutYProperty().bind(env.getPersonage().yProperty().subtract(scene.getHeight()/2));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
