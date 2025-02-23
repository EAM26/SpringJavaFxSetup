package org.eam.code.springbootjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.io.IOException;

@Component // So Spring can detect and manage this bean
public class MyViewController {

    @FXML
    private Button btnClick;

    @FXML
    private Label lbHeader;

    // Optionally, you can use @Autowired for Spring-managed services
    // @Autowired
    // private MyService myService;

    @FXML
    private void initialize() {
        // This method is called automatically after the FXML is loaded

    }

    @FXML
    void showMessage() throws IOException {
        lbHeader.setText("Button clicked!");
        JavaFxApp.setScreenToSecondView();

    }
}
