package p05_speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1KM;
    private int distanceTravelled;

    public Car(String mode, double fuelAmount, double fuelCostPer1KM) {
        this.setModel(mode);
        this.setFuelAmount(fuelAmount);
        this.setFuelCostPer1KM(fuelCostPer1KM);
        this.setDistanceTravelled(0);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPer1KM() {
        return this.fuelCostPer1KM;
    }

    private void setFuelCostPer1KM(double fuelCostPer1KM) {
        this.fuelCostPer1KM = fuelCostPer1KM;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void move(int amountOfKM) {
        double neededFuel = amountOfKM * this.getFuelCostPer1KM();
        if (neededFuel > this.getFuelAmount()) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }

        this.setFuelAmount(this.getFuelAmount() - neededFuel);
        this.setDistanceTravelled(this.getDistanceTravelled() + amountOfKM);
    }

    @Override
    public String toString() {
        return this.getModel();
    }
}
