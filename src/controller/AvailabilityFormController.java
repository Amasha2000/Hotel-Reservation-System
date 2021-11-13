package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


public class AvailabilityFormController {
    public JFXDatePicker checkInDate;
    public JFXDatePicker checkOutDate;
    public JFXComboBox cmbAdults;
    public JFXComboBox cmbChildren;
    public JFXComboBox cmbRoomType;
    public JFXComboBox cmbRoomNumber;
    public JFXTextField txtUnderMaintenance;

    ObservableList<Integer> adultNum;
    ObservableList<Integer> childrenNum;
    ObservableList<String> roomName;
    ObservableList<Integer> roomNumber;
    public void initialize(){
        adultNum= FXCollections.observableArrayList(1,2,3,4);
        cmbAdults.setItems(adultNum);
         childrenNum= FXCollections.observableArrayList(1,2,3,4);
        cmbChildren.setItems(childrenNum);
        roomName= FXCollections.observableArrayList("Single","Double","Triple","Quad");
        cmbRoomType.setItems(roomName);
        roomNumber= FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25);
        cmbRoomNumber.setItems(roomNumber);

        }

      public void btnCheck(ActionEvent actionEvent) {
        boolean isCmbRoomNumberEmpty =cmbRoomNumber.getSelectionModel().isEmpty();
            if(!isCmbRoomNumberEmpty){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
                alert.setHeaderText("Room is AVAILABLE");
                alert.showAndWait();
                removeItem(cmbRoomNumber.getSelectionModel().getSelectedIndex());
                checkInDate.getEditor().clear();
                checkOutDate.getEditor().clear();
                cmbAdults.getSelectionModel().clearSelection();
                cmbChildren.getSelectionModel().clearSelection();
                cmbRoomType.getSelectionModel().clearSelection();
                cmbRoomNumber.setValue(null);
                return;
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
                alert.setHeaderText("Room is NOT AVAILABLE");
                alert.showAndWait();
            }
        }

            private void removeItem(int selectedIndex) {
            roomNumber.remove(selectedIndex);
    }

            public void btnSave(ActionEvent actionEvent) {
                int num= Integer.parseInt(txtUnderMaintenance.getText());
                removeItem(roomNumber.indexOf(num));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                alert.setHeaderText("Room set as Under Maintenance");
                alert.showAndWait();
    }
}

