package view.tm;

import javafx.scene.control.Button;

public class PackageTM {
    private String packages;
    private String price;
    private Button btn;

    public PackageTM() {
    }

    public PackageTM(String packages, String price, Button btn) {
        this.setPackages(packages);
        this.setPrice(price);
        this.setBtn(btn);
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
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
