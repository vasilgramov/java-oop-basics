package p04_shippingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) throws Exception {
        this.setName(name);
        this.setCost(cost);
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

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) throws Exception {
        if (cost < 0) {
            throw new Exception("Money cannot be negative");
        }

        this.cost = cost;
    }
}
