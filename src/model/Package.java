package model;

public class Package {
    private String packages;
    private String price;

    public Package(String packages, String price) {
        this.setPackages(packages);
        this.setPrice(price);
    }

    public Package() {
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
}
