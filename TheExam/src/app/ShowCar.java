package app;

import app.Car;

public class ShowCar extends Car {
    private static final String SHOW_CAR = "Show";

    private int stars;
    private String type;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        super.setType(SHOW_CAR);
    }

    public int getStars() {
        return this.stars;
    }

    public void increaseStars(int stars) {
        this.stars = this.getStars() + stars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("%d *\n", this.getStars()));

        return builder.toString();
    }
}
