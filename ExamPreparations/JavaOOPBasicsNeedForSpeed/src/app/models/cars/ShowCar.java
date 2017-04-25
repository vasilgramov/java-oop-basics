package app.models.cars;

/**
 * Created by vladix on 4/25/17.
 */
public class ShowCar extends AbstractCar {

    private int stars;

    public ShowCar(String name, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(name, model, yearOfProduction, horsePower, acceleration, suspension, durability);
    }

    public int getStars() {
        return this.stars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator()).append(String.format("%s *", this.getStars()));

        return builder.toString();
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.horsePower = super.horsePower + tuneIndex;
        super.suspension = super.suspension + (tuneIndex / 2);
        this.stars = this.stars + tuneIndex;
    }
}
