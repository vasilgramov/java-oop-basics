package app;

import app.Car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private static final String PERFORMANCE_CAR = "Performance";

    private List<String> addOns;
    private String type;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower + (horsepower * 50) / 100, acceleration, suspension - (suspension * 25) / 100, durability);

        this.addOns = new ArrayList<>();
        super.setType(PERFORMANCE_CAR);
    }

    public void addAddon(String addon) {
        this.addOns.add(addon);
    }


    private String listAddons() {
        if (this.addOns.size() == 0) {
            return "None";
        }

        return this.addOns.toString().replace("[", "").replace("]", "");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("Add-ons: %s\n", this.listAddons()));

        return builder.toString();
    }
}
