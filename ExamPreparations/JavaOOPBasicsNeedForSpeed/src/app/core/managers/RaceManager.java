package app.core.managers;

import app.models.cars.Car;
import app.models.garages.CarGarage;
import app.models.garages.Garage;
import app.models.races.Race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public class RaceManager implements Manager {

    private Map<Integer, Car> carById;
    private Map<Integer, Race> raceById;
    private Garage garage;

    public RaceManager() {
        this.carById = new HashMap<>();
        this.raceById = new HashMap<>();
        this.garage = new CarGarage();
    }

    @Override
    public void registerCar(int id, Car car) {
        this.carById.put(id, car);
    }

    @Override
    public String check(int id) {
        return this.carById.get(id).toString();
    }

    @Override
    public void openRace(int id, Race race) {
        this.raceById.put(id, race);
    }

    @Override
    public void participate(int carId, int raceId) {
        Car car = this.carById.get(carId);
        Race race = this.raceById.get(raceId);

        race.addParticipant(car);
    }

    @Override
    public String startRace(int raceId) {
        Race race = this.raceById.get(raceId);
        return race.start();
    }

    @Override
    public void park(int carId) {
        Car car = this.carById.remove(carId);
        this.garage.park(carId, car);
    }

    @Override
    public void unpark(int carId) {
        Car unpark = this.garage.unpark(carId);
        this.carById.put(carId, unpark);
    }


}
