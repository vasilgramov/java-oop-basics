package app.core.managers;

import app.models.cars.Car;
import app.models.races.Race;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by vladix on 4/25/17.
 */
public interface Manager {

    void registerCar(int id, Car car);

    String check(int id);

    void openRace(int id, Race race);

    void participate(int carId, int raceId);

    String startRace(int raceId);

    void park(int carId);

    void unpark(int carId);

    void tune(int tuneIndex, String tuneAddOn);
}
