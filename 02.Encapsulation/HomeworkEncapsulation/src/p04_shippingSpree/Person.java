package p04_shippingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) throws Exception {
        this.products = new ArrayList<>();

        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) throws Exception {
        if (name == null || name.trim().length() == 0) {
            throw new Exception("Name cannot be empty");
        }

        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    private void setMoney(double money) throws Exception {
        if (money < 0) {
            throw new Exception("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean canPurchase(Product product) {
        return this.getMoney() >= product.getCost();
    }

    public void purchase(Product product) throws Exception {
        this.setMoney(this.getMoney() - product.getCost());
        this.products.add(product);
    }
}
