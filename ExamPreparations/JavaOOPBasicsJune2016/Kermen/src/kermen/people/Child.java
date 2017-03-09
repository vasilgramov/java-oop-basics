package kermen.people;

import kermen.devices.Toy;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private double foodCost;
    private List<Toy> toys;

    public Child(double foodCost) {
        this.toys = new ArrayList<>();
        this.setFoodCost(foodCost);
    }

    public double getFoodCost() {
        return this.foodCost;
    }

    private void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public double getAllToysCost() {
        double total = 0;
        for (Toy toy : this.toys) {
            total += toy.getCost();
        }

        return total;
    }
}
