package app.models.races;

import app.models.cars.Car;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public class DragRace extends AbstractRace {


    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }


    @Override
    protected Map<Car, Integer> getWinners() {
        Map<Car, Integer> winners = new LinkedHashMap<>();

        super.getParticipants().values().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getEnginePerformance(), c1.getEnginePerformance()))
                .limit(3)
                .forEach(c -> {
                    winners.put(c, c.getEnginePerformance());
                });

        return winners;
    }

}
