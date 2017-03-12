package app;

public class TimeLimitRace extends Race {
    private int goldTime;
    private Car car;

    public TimeLimitRace(int length, String route, int pricePool, int goldTime) {
        super(length, route, pricePool);
        super.setType("TimeLimit");

        this.setGoldTime(goldTime);
    }

    public int getGoldTime() {
        return this.goldTime;
    }

    private void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    public void addPlayer(Car car) {
        if (this.car == null) {
            this.car = car;
        }
    }

    @Override
    public String start() {
        StringBuilder builder = new StringBuilder();

        int time = super.getLength() * ((this.car.getHorsepower() / 100) * this.car.getAcceleration());

        builder.append(String.format("%s %s - %d s.", this.car.getBrand(), this.car.getModel(), time));
        if (time <= this.getGoldTime()) {
            builder.append(String.format("Gold Time, $%d", super.getPricePool()));
        } else if (time <= this.getGoldTime() + 15) {
            builder.append(String.format("Silver Time, $%d", (super.getPricePool() * 50) / 100));
        } else {
            builder.append(String.format("Bronze Time, $%d", (super.getPricePool() * 20) / 100));
        }

        return builder.toString();
    }
}
