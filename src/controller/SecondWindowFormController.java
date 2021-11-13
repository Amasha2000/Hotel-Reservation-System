package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;



public class SecondWindowFormController {
    public AnchorPane secondPageContext;
    public AnchorPane availabilityContext;


    public void openAvailabilityWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AvailabilityForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) secondPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void openReservationWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MakeReservationForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }

    public void openRoomDetailWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RoomDetailForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }

    public void openMealPlanDetailWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MealPlanDetailForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }

    public void openPackageWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PackageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }

    public void openIncomeReportWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/IncomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        availabilityContext.getChildren().clear();
        availabilityContext.getChildren().add(load);
    }
}
