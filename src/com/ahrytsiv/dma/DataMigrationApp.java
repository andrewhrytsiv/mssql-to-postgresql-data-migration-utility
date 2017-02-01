package com.ahrytsiv.dma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataMigrationApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
       /* Parent root = FXMLLoader.load(getClass().getResource("setup.fxml"));
        primaryStage.setTitle("Data Migration Application");
        primaryStage.setScene(new Scene(root, 1024, 600));
        primaryStage.show();*/
        try {
            stage = primaryStage;
//            openSetupScreen();
            openCleanupScreen();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void openSetupScreen() {
        try {
            replaceSceneContent("setup.fxml");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void openCleanupScreen() {
        try {
            replaceSceneContent("cleanup.fxml");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(DataMigrationApp.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 1024, 600);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
}
