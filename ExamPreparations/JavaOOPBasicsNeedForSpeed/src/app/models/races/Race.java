package app.models.races;

import app.models.cars.Car;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vladix on 4/25/17.
 */
public interface Race {

    int getLength();

    String getRoute();

    int getPrizePool();

    List<Car> getParticipants();

    void addParticipant(Car car);

    String start();

}
