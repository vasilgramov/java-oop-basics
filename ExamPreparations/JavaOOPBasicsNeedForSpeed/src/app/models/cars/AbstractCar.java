package app.models.cars;

/**
 * Created by vladix on 4/25/17.
 */
public abstract class AbstractCar implements Car {

    private String name;
    private String model;
    private int yearOfProduction;
    protected int horsePower;
    private int acceleration;
    protected int suspension;
    private int durability;

    public AbstractCar(String name, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.name = name;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getAcceleration() {
        return this.acceleration;
    }

    @Override
    public int getSuspension() {
        return this.suspension;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public int getOverallPerformance() {
        // (horsepower / acceleration) + (suspension + durability)
        return (this.getHorsePower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    @Override
    public int getEnginePerformance() {
        // (horsepower / acceleration)
        return this.getHorsePower() / this.getAcceleration();
    }

    @Override
    public int getSuspensionPerformance() {
        // (suspension + durability)
        return this.getSuspension() + this.getDurability();
    }

    @Override
    public String toString() {
        /*
        “{brand} {model} {yearOfProduction}
         {horsepower} HP, 100 m/h in {acceleration} s
         {suspension} Suspension force, {durability} Durability”
         */

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %s", this.getName(), this.getModel(), this.getYearOfProduction())).append(System.lineSeparator())
                .append(String.format("%s HP, 100 m/h in %s s", this.getHorsePower(), this.getAcceleration())).append(System.lineSeparator())
                .append(String.format("%s Suspension force, %s Durability", this.getSuspension(), this.getDurability()));

        return builder.toString();
    }
}
