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

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator()).append(String.format("%s *", this.getStars()));

        return builder.toString();
    }
}
