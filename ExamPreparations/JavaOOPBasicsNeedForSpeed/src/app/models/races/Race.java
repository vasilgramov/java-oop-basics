package app.models.races;

import app.models.cars.Car;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public interface Race {

    int getLength();

    String getRoute();

    int getPrizePool();

    Map<Integer, Car> getParticipants();

    void addParticipant(int id, Car car);

    String start();

}
