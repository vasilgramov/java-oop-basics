package p06_rawData;

public class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.setCargoWeight(cargoWeight);
        this.setCargoType(cargoType);
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }

    private void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
