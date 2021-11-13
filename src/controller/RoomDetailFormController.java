package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Rooms;
import view.tm.RoomsTM;

import java.util.ArrayList;
import java.util.Optional;

public class RoomDetailFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtNumber;
    public JFXTextField txtType;
    public JFXTextField txtSize;
    public TableView<RoomsTM> tblRooms;
    public TableColumn colNumber;
    public TableColumn colType;
    public TableColumn colSize;
    public TableColumn colDelete;

    static ArrayList<Rooms> roomList=new ArrayList<>();

    public void initialize() {
        colNumber.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        colType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("roomSize"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblRooms.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue==null){

            }else {
                loadRooms(newValue);
            }
        }));
    }

    private void loadRooms(RoomsTM tm) {
        txtNumber.setText(tm.getRoomNum());
        txtType.setText(tm.getRoomType());
        txtSize.setText(tm.getRoomSize());
    }

    public void moveToNumber(ActionEvent actionEvent) {
        txtNumber.requestFocus();
    }

    public void moveToType(ActionEvent actionEvent) {
        txtType.requestFocus();
    }

    public void moveToSize(ActionEvent actionEvent) {
        txtSize.requestFocus();
    }
    public boolean isExists(Rooms rooms){
        for(Rooms r:roomList){
            if(r.getRoomNumber().equalsIgnoreCase(rooms.getRoomNumber())){
                return true;
            }
        }
        return false;
    }

    public void addOnAction(ActionEvent actionEvent) {
        Rooms rooms=new Rooms(txtNumber.getText(),txtType.getText(),txtSize.getText());
        txtNumber.clear();
        txtType.clear();
        txtSize.clear();
        if(!isExists(rooms)){
            if(roomList.add(rooms)){
                loadAllRooms();
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Added\nClick the relevant row of the table to edit", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again", ButtonType.OK).show();
        }
        }else{
            new Alert(Alert.AlertType.WARNING,"Already Exists", ButtonType.OK).show();
        }
    }

    private void loadAllRooms(){
        ObservableList<RoomsTM> tmObservableList= FXCollections.observableArrayList();
            for (Rooms tempRooms:roomList){
                Button btn=new Button("Delete");
                tmObservableList.add(new RoomsTM(tempRooms.getRoomNumber(),tempRooms.getRoomType(),tempRooms.getRoomSize(),btn));
                btn.setOnAction((e)->{
                    ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this room?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result=alert.showAndWait();
                if(!(result.orElse(yes)==no)){
                    roomList.remove(tempRooms);
                    loadAllRooms();
                }else {

                    }
                });
            }
            tblRooms.setItems(tmObservableList);
    }

    public void checkOnAction(ActionEvent actionEvent) {
       if(txtPassword.getText().equalsIgnoreCase("admin")){
            new Alert(Alert.AlertType.CONFIRMATION,"OK",ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Only admin can change details",ButtonType.CLOSE).show();
        }
    }
}
