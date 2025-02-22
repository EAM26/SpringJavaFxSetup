package org.eam.code.springbootjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component // So Spring can detect and manage this bean
public class MyViewController {

    @FXML
    private Button myButton;

    @FXML
    private Label myLabel;

    // Optionally, you can use @Autowired for Spring-managed services
    // @Autowired
    // private MyService myService;

    @FXML
    private void initialize() {
        // This method is called automatically after the FXML is loaded
        myButton.setOnAction(event -> myLabel.setText("Button clicked!"));
    }
}
