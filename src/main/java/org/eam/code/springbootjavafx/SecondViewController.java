package org.eam.code.springbootjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.eam.code.springbootjavafx.Person.Person;
import org.eam.code.springbootjavafx.Person.PersonRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecondViewController {

    private final PersonRepository personRepository;
    @FXML
    private Button btnSecViewBack;

    public SecondViewController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @FXML
    void backToHappyView(ActionEvent event) throws IOException {
        JavaFxApp.setScreenToMyView();
    }

    @FXML
    private Button btnSetLabel;

    @FXML
    private Label lbName;

    @FXML
    void setLabel(ActionEvent event) {
        Person person = new Person("Piet");
        personRepository.save(person);
        personRepository.findById(1L).ifPresent(person1 -> lbName.setText(person1.getName()));

    }

}
