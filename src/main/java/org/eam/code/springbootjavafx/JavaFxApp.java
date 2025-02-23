package org.eam.code.springbootjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception {
        System.out.println("Init method in JavaFXApp running.\n");
        springContext = new SpringApplicationBuilder(MySpringBootApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start method in JavaFXApp running.\n");
        // 1. Create FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MyView.fxml"));

        // 2. Let Spring manage the controller
        fxmlLoader.setControllerFactory(springContext::getBean);

        // 3. Load the FXML
        Parent root = fxmlLoader.load();

        // 4. Build and show the scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Spring Boot + JavaFX + FXML");
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("Stop method in JavaFXApp running.\n");
        springContext.close();
        Platform.exit();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application.
        System.out.println("Main method in JavaFxApp running.\n");
        launch(args);
    }
}
