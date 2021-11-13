package controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import view.tm.CustomerTM;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class MakeReservationFormController {
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtTelNumber;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtRoomNumber;
    public JFXTextField txtPayment;
    public AnchorPane reservationContext;
    public JFXTimePicker arrivalTimePicker;
    public JFXTimePicker departureTimePicker;
    public JFXDatePicker arrivalDatePicker;
    public JFXDatePicker departureDatePicker;

    static ArrayList<Customer> customerList=new ArrayList<>();
    public TableView<CustomerTM> tblView;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colCheckInDate;
    public TableColumn colCheckOutDate;
    public TableColumn colRoomNo;
    public TableColumn colPayment;
    public TableColumn colCancel;

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colCheckInDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        colCheckOutDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        colCancel.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblView.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if(newValue==null){

            }else{
                try {
                    loadData(newValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    private void loadData(CustomerTM tm) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ReservationDetailsForm.fxml"));
        Parent parent = loader.load();
        ReservationDetailsFormController controller = loader.getController();
        controller.setData(tm);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public boolean isExists(Customer customer){
        for(Customer temp:customerList){
            if(temp.getNic().equalsIgnoreCase(customer.getNic())){
                return true;
            }
        }
        return false;
    }

    public void saveOnAction(ActionEvent actionEvent) {
        Customer customer = new Customer(txtName.getText(), txtNIC.getText(), txtTelNumber.getText(), txtEmail.getText(), txtAddress.getText(),
                txtPayment.getText(), txtRoomNumber.getText(), arrivalDatePicker.getValue(), departureDatePicker.getValue(),arrivalTimePicker.getValue(),departureTimePicker.getValue());
        txtName.clear();
        txtNIC.clear();
        txtTelNumber.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtRoomNumber.clear();
        txtPayment.clear();
        arrivalDatePicker.getEditor().clear();
        departureDatePicker.getEditor().clear();
        arrivalTimePicker.getEditor().clear();
        departureTimePicker.getEditor().clear();
        txtNIC.clear();
        if (!isExists(customer)) {
            if (customerList.add(customer)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved\nClick the relevant row in the table to view Details", ButtonType.OK).show();
                loadsAllCustomer();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Already Exists", ButtonType.OK).show();
        }
    }

        public void loadsAllCustomer(){
            ObservableList<CustomerTM> tmObservableList= FXCollections.observableArrayList();
            for(Customer temp:customerList){
                Button btn=new Button("Cancel");
                tmObservableList.add(new CustomerTM(temp.getName(), temp.getNic(), temp.getContact(), temp.getEmail(), temp.getAddress(),
                        temp.getPayment(),temp.getRoomNumber(),temp.getArrivalDate(),temp.getDepartureDate(),temp.getArrivalTime(),temp.getDepartureTime(),btn));
                btn.setOnAction((e)->{
                    ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                    ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to cancel this reservation ?",yes,no);
                    alert.setTitle("Confirmation");
                    Optional<ButtonType> result=alert.showAndWait();
                    if(result.orElse(yes)==no){

                    }else{
                        customerList.remove(temp);
                        loadsAllCustomer();
                    }
                });
            }
            tblView.setItems(tmObservableList);
        }


    public void moveToRoomNumber(ActionEvent actionEvent) {
        txtRoomNumber.requestFocus();
    }

    public void moveToTelNo(ActionEvent actionEvent) {
        txtTelNumber.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToArrivalTime(ActionEvent actionEvent) {
        arrivalTimePicker.requestFocus();
    }

    public void moveToNIC(ActionEvent actionEvent) {
        txtNIC.requestFocus();
    }

    public void moveToArrivalDate(ActionEvent actionEvent) {
        arrivalDatePicker.requestFocus();
    }

    public void moveToDepartureDate(ActionEvent actionEvent) {
        departureDatePicker.requestFocus();
    }

    public void moveToDepartureTime(ActionEvent actionEvent) {
        departureTimePicker.requestFocus();
    }

    public void moveToPayment(ActionEvent actionEvent) {
        txtPayment.requestFocus();
    }

    public void printOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PrintTokenForm.fxml");
        Parent load = FXMLLoader.load(resource);
        reservationContext.getChildren().clear();
        reservationContext.getChildren().add(load);
    }
}
