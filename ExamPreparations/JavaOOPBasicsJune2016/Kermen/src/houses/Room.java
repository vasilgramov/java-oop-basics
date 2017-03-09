package houses;

public class Room {
    private double electricity;

    public Room(double electricity) {
        this.setElectricity(electricity);
    }

    public double getElectricity() {
        return this.electricity;
    }

    private void setElectricity(double electricity) {
        this.electricity = electricity;
    }
}
