package p01_vehicle;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if (super.getFuelQuantity() + fuelQuantity > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void drive(double kms) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#############");
        double neededFuel = super.getFuelConsumption() * kms;
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Car needs refueling");
        }

        this.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        System.out.println("Car travelled " + decimalFormat.format(kms) + " km");
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(super.getFuelQuantity() + liters);
    }
}
