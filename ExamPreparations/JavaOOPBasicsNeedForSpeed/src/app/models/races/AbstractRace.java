package app.models.races;

import app.models.cars.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vladix on 4/25/17.
 */
public abstract class AbstractRace implements Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public AbstractRace(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;

        this.participants = new ArrayList<>();
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getRoute() {
        return this.route;
    }

    @Override
    public int getPrizePool() {
        return this.prizePool;
    }

    @Override
    public List<Car> getParticipants() {
        return this.participants;
    }

    @Override
    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    @Override
    public String start() {
        List<Car> participants = this.getParticipants();
        List<Car> result = participants.stream()
                .sorted(this.getComparator())
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %s", this.getRoute(), this.getLength()))
                .append(System.lineSeparator());

        int[] prices = getPrices();

        for (int i = 1; i <= result.size(); i++) {
            Car car = result.get(i - 1);
            builder.append(String.format("%s. %s %s %sPP - $%s",
                    i, car.getName(), car.getModel(), car.getOverallPerformance(), prices[i - 1]))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    private int[] getPrices() {
        int[] prices = new int[3];
        prices[0] = (this.getPrizePool() * 50) / 100;
        prices[1] = (this.getPrizePool() * 30) / 100;
        prices[2] = (this.getPrizePool() * 20) / 100;
        return prices;
    }

    protected abstract Comparator<Car> getComparator();
}
