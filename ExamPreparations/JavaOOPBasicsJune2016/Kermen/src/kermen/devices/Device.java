package kermen.devices;

public abstract class Device {
    private double electricityCost;

    public Device(double electricityCost) {
        this.setCost(electricityCost);
    }

    public double getElectricityCost() {
        return this.electricityCost;
    }

    private void setCost(double electricityCost) {
        this.electricityCost = electricityCost;
    }
}
