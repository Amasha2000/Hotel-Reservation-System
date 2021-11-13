package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class PrintTokenFormController {
    public void printOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Token has printed successfully", ButtonType.OK).show();
    }

    public void sendViaEmailOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Token has sent via Email", ButtonType.OK).show();
    }
}
