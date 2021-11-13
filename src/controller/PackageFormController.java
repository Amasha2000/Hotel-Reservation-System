package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MealPlan;
import model.Package;
import view.tm.MealPlanTM;
import view.tm.PackageTM;

import java.util.ArrayList;
import java.util.Optional;

public class PackageFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtPackage;
    public JFXTextField txtPrice;
    public TableView<PackageTM> tblPackage;
    public TableColumn colName;
    public TableColumn colPrice;
    public TableColumn colDelete;

    static ArrayList<Package> packageList=new ArrayList<>();

    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("packages"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblPackage.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue==null){

            }else {
                loadPackages(newValue);
            }
        }));
    }

    private void loadPackages(PackageTM tm) {
        txtPackage.setText(tm.getPackages());
        txtPrice.setText(tm.getPrice());

    }

    public boolean isExists(Package packages){
        for(Package p:packageList){
            if(p.getPackages().equalsIgnoreCase(packages.getPackages())){
                return true;
            }
        }
        return false;
    }

    public void addOnAction(ActionEvent actionEvent) {
        Package packages=new Package(txtPackage.getText(),txtPrice.getText());
        txtPackage.clear();
        txtPrice.clear();
        if(!isExists(packages)){
            if(packageList.add(packages)){
                loadAllPackages();
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Added\nClick the relevant row of the table to edit", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again", ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Already Exists", ButtonType.OK).show();
        }
    }


    private void loadAllPackages(){
        ObservableList<PackageTM> tmObservableList= FXCollections.observableArrayList();
        for (Package tempPackage:packageList){
            Button btn=new Button("Delete");
            tmObservableList.add(new PackageTM(tempPackage.getPackages(),tempPackage.getPrice(),btn));
            btn.setOnAction((e)->{
                ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this package?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result=alert.showAndWait();
                if(!(result.orElse(yes)==no)){
                    packageList.remove(tempPackage);
                    loadAllPackages();
                }else {

                }
            });
        }
        tblPackage.setItems(tmObservableList);
    }


    public void checkOnAction(ActionEvent actionEvent) {
        if(txtPassword.getText().equalsIgnoreCase("admin")){
            new Alert(Alert.AlertType.CONFIRMATION,"OK",ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Only admin can change details",ButtonType.CLOSE).show();
        }
    }

    public void moveToPrice(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }


}
