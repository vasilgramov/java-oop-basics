package p01_vehicle;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        if (tankCapacity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.tankCapacity = tankCapacity;
    }

    public abstract void drive(double kms);

    public abstract void refuel(double liters);
}
