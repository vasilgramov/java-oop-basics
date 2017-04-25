package app.models.races;

import app.models.cars.Car;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vladix on 4/25/17.
 */
public abstract class AbstractRace implements Race {

    private int length;
    private String route;
    private int prizePool;
    private Map<Integer, Car> participants;

    public AbstractRace(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;

        this.participants = new LinkedHashMap<>();
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
    public Map<Integer, Car> getParticipants() {
        return this.participants;
    }

    @Override
    public void addParticipant(int id, Car car) {
        this.participants.put(id, car);
    }

    @Override
    public String start() {
        Map<Car, Integer> winners = this.getWinners();

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %s", this.getRoute(), this.getLength()))
                .append(System.lineSeparator());

        int[] prices = getPrices();
        int index = 1;
        for (Map.Entry<Car, Integer> carIntegerEntry : winners.entrySet()) {
            Car car = carIntegerEntry.getKey();
            builder.append(String.format("%s. %s %s %sPP - $%s",
                    index, car.getName(), car.getModel(), carIntegerEntry.getValue(), prices[index - 1]))
                    .append(System.lineSeparator());
            index++;
        }

        this.participants = new HashMap<>();
        return builder.toString().trim();
    }

    private int[] getPrices() {
        int[] prices = new int[3];
        prices[0] = (this.getPrizePool() * 50) / 100;
        prices[1] = (this.getPrizePool() * 30) / 100;
        prices[2] = (this.getPrizePool() * 20) / 100;
        return prices;
    }

    protected abstract Map<Car, Integer> getWinners();

}
