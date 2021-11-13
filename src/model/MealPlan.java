package model;

public class MealPlan {
    private String mealPlan;
    private String Price;

    public MealPlan() {
    }

    public MealPlan(String mealPlan, String price) {
        this.setMealPlan(mealPlan);
        setPrice(price);
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
