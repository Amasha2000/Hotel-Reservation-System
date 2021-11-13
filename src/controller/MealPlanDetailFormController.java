package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MealPlan;
import view.tm.MealPlanTM;


import java.util.ArrayList;
import java.util.Optional;

public class MealPlanDetailFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtPlan;
    public JFXTextField txtPrice;
    public TableView<MealPlanTM> tblMealPlan;
    public TableColumn colPlan;
    public TableColumn colPrice;
    public TableColumn colDelete;

    static ArrayList<MealPlan> mealList=new ArrayList<>();
    public void initialize() {
        colPlan.setCellValueFactory(new PropertyValueFactory<>("meal"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblMealPlan.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue==null){

            }else {
                loadMealPlans(newValue);
            }
        }));
    }

    private void loadMealPlans(MealPlanTM tm) {
        txtPlan.setText(tm.getMeal());
        txtPrice.setText(tm.getPrice());

    }

    public boolean isExists(MealPlan meals){
        for(MealPlan m:mealList){
            if(m.getMealPlan().equalsIgnoreCase(meals.getMealPlan())){
                return true;
            }
        }
        return false;
    }

    public void addOnAction(ActionEvent actionEvent) {
        MealPlan meals=new MealPlan(txtPlan.getText(),txtPrice.getText());
        txtPlan.clear();
        txtPrice.clear();
        if(!isExists(meals)){
            if(mealList.add(meals)){
                loadAllMeals();
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Added\nClick the relevant row of the table to edit", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again", ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Already Exists", ButtonType.OK).show();
        }
    }

    private void loadAllMeals(){
        ObservableList<MealPlanTM> tmObservableList= FXCollections.observableArrayList();
        for (MealPlan tempMeal:mealList){
            Button btn=new Button("Delete");
            tmObservableList.add(new MealPlanTM(tempMeal.getMealPlan(),tempMeal.getPrice(),btn));
            btn.setOnAction((e)->{
                ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this meal?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result=alert.showAndWait();
                if(!(result.orElse(yes)==no)){
                    mealList.remove(tempMeal);
                    loadAllMeals();
                }else {

                }
            });
        }
        tblMealPlan.setItems(tmObservableList);
    }


    public void moveToMealPlan(ActionEvent actionEvent) {
        txtPlan.requestFocus();
    }

    public void checkOnAction(ActionEvent actionEvent) {
        if(txtPassword.getText().equalsIgnoreCase("admin")){
            new Alert(Alert.AlertType.CONFIRMATION,"OK",ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Only admin can change details",ButtonType.CLOSE).show();
        }
    }

}
