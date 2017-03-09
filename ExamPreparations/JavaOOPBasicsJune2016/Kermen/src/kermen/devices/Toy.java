package kermen.devices;

public class Toy {
    private double cost;

    public Toy(double cost) {
        this.setCost(cost);
    }

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }
}
