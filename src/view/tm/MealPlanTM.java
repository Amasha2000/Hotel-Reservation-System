package view.tm;

import javafx.scene.control.Button;

public class MealPlanTM {
    private String meal;
    private String price;
    private Button btn;

    public MealPlanTM() {
    }

    public MealPlanTM(String meal, String price, Button btn) {
        this.setMeal(meal);
        this.setPrice(price);
        this.setBtn(btn);
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
