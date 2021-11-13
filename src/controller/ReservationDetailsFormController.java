package controller;

import com.jfoenix.controls.JFXTextField;
import view.tm.CustomerTM;

import java.time.format.DateTimeFormatter;

public class ReservationDetailsFormController {


    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtCheckOutDate;
    public JFXTextField txtCheckInDate;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtTelNum;
    public JFXTextField txtRoomNum;
    public JFXTextField txtPayment;

    public void setData(CustomerTM tm){
        txtName.setText(tm.getName());
        txtNIC.setText(tm.getNic());
        txtCheckInDate.setText(tm.getArrivalDate().toString());
        txtCheckOutDate.setText(tm.getDepartureDate().toString());
        txtAddress.setText(tm.getAddress());
        txtEmail.setText(tm.getEmail());
        txtTelNum.setText(tm.getContact());
        txtRoomNum.setText(tm.getRoomNumber());
        txtPayment.setText(tm.getPayment());
    }

}
