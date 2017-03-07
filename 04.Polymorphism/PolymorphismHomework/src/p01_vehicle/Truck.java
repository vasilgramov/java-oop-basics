package p01_vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kms) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#########");
        double neededFuel = kms * super.getFuelConsumption();
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        System.out.println("Truck travelled " + decimalFormat.format(kms) + " km");
    }

    @Override
    public void refuel(double liters) {
        liters = liters * 0.95;
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }
}
