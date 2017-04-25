package app.models.races;

import app.models.cars.Car;

import java.util.Comparator;

/**
 * Created by vladix on 4/25/17.
 */
public class CasualRace extends AbstractRace {


    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected Comparator<Car> getComparator() {
        return (p1, p2) -> Integer.compare(p2.getOverallPerformance(), p1.getOverallPerformance());
    }

}
