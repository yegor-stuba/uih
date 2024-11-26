package sv.library;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LibraryFrontend extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Sample JavaFX UI setup
        Label label = new Label("Welcome to the Library Management System");

        // Set up the scene and stage
        Scene scene = new Scene(label, 400, 300);
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }
}
