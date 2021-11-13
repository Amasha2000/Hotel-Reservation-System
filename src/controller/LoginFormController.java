package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public JFXTextField userNameField;
    public JFXPasswordField passwordField;
    public JFXToggleButton adminButton;
    public AnchorPane mainPageContext;

    public void moveToPassword(ActionEvent actionEvent) {
        passwordField.requestFocus();
    }

    public void enterPassword(ActionEvent actionEvent) {
        if (passwordField.getLength() < 8) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Password must have at least 8 characters");
            alert.setTitle("Error");
            alert.show();
            passwordField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setHeaderText("Password is valid");
            alert.show();
        }
    }

    public void adminButtonAction(ActionEvent actionEvent) {
        if (adminButton.isSelected()){
            adminButton.setText("Admin");
        }else{
            adminButton.setText("Receptionist");
        }
    }

    public void newUserAction(ActionEvent actionEvent) throws IOException {
        if ("".equalsIgnoreCase(userNameField.getText()) || "".equalsIgnoreCase(passwordField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all the fields...");
            alert.setTitle("Error");
            alert.showAndWait();
            return;
        }else{
            URL resource = getClass().getResource("../view/SecondWindowForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) mainPageContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }

    }
}



