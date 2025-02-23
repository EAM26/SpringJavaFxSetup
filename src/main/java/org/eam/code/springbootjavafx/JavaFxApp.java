package org.eam.code.springbootjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext springContext;
    private static Stage primaryStage;

    @Override
    public void init() throws Exception {
        System.out.println("Init method in JavaFXApp running.\n");
        springContext = new SpringApplicationBuilder(MySpringBootApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        System.out.println("Start method in JavaFXApp running.\n");
        setScreenToMyView();

    }

    public static void showScreen(FXMLLoader fxmlLoader) throws IOException {
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

    public static void setScreenToMyView() throws IOException {
        // 1. Create FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/MyView.fxml"));
        showScreen(fxmlLoader);

    }

    public static void setScreenToSecondView() throws IOException {
        // 1. Create FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/SecondView.fxml"));
        showScreen(fxmlLoader);
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
