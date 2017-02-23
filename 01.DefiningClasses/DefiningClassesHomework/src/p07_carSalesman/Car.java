package p07_carSalesman;

public class Car {
    private static final String DEFAULT = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, -1, DEFAULT);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, DEFAULT);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.setModel(model);
        this.setEngine(engine);
        this.setWeight(weight);
        this.setColor(color);
    }


    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String weightToPrint = this.getWeight() == -1 ? DEFAULT : Integer.toString(this.getWeight());

        StringBuilder builder = new StringBuilder();
        builder.append(this.getModel() + ":" + "\n")
                .append(this.getEngine() + "\n")
                .append("  Weight: " + weightToPrint + "\n")
                .append("  Color: " + this.getColor());

        return builder.toString();
    }
}
