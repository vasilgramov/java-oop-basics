package p07_carSalesman;

public class Engine {
    private static final String DEFAULT = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this(model, power, -1, DEFAULT);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, DEFAULT);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return this.power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    private void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    private void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementToPrint = this.getDisplacement() == -1 ? DEFAULT : Integer.toString(this.getDisplacement());

        StringBuilder builder = new StringBuilder();
        builder.append("  " + this.getModel() + ":" + "\n")
                .append("    Power: " + this.getPower() + "\n")
                .append("    Displacement: " + displacementToPrint + "\n")
                .append("    Efficiency: " + this.getEfficiency());

        return builder.toString();
    }
}
