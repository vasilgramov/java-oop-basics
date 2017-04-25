package app.models.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladix on 4/25/17.
 */
public class PerformanceCar extends AbstractCar {

    private List<String> addons;

    public PerformanceCar(String name, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(name, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.calcHorsePower();
        this.calcSuspension();
        this.addons = new ArrayList<>();

    }

    public List<String> getAddons() {
        return this.addons;
    }

    private void setAddons(List<String> addons) {
        this.addons = addons;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator()).append(String.format("Add-ons: %s", this.listAddons()));
        return builder.toString();
    }

    private String listAddons() {
        if (this.getAddons().size() == 0) {
            return "None";
        }

        return String.join(", ", this.getAddons());
    }

    private void calcHorsePower() {
        super.horsePower = super.getHorsePower() + (super.getHorsePower() * 50) / 100;
    }

    private void calcSuspension() {
        super.suspension = super.getSuspension() - (super.getSuspension() * 25) / 100;
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.horsePower = super.horsePower + tuneIndex;
        super.suspension = super.suspension + (tuneIndex / 2);
        this.addons.add(tuneAddOn);
    }
}
