package p01_vehicle;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if (super.getFuelQuantity()  + fuelQuantity > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void drive(double kms) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#############");
        double neededFuel = super.getFuelConsumption() * kms;
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Bus needs refueling");
        }

        this.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        System.out.println("Bus travelled " + decimalFormat.format(kms) + " km");
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    public void driveWithPeople(double kms) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#############");
        double neededFuel = (super.getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION) * kms ;
        if (kms > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Bus needs refueling");
        }

        this.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        System.out.println("Bus travelled " + decimalFormat.format(kms) + " km");
    }
}
