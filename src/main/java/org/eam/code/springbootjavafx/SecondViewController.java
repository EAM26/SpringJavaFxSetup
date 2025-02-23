package org.eam.code.springbootjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecondViewController {

    @FXML
    private Button btnSecViewBack;

    @FXML
    void backToHappyView(ActionEvent event) throws IOException {
        JavaFxApp.setScreenToMyView();
    }

}
