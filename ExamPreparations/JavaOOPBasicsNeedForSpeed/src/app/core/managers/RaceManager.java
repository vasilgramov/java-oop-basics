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

    public static final String CANNOT_START_THE_RACE_WITH_ZERO_PARTICIPANTS = "Cannot start the race with zero participants.";
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
        if (isInGarage(carId)) {
            return;
        }

        Car car = this.carById.get(carId);
        Race race = this.raceById.get(raceId);

        race.addParticipant(carId, car);
    }

    @Override
    public String startRace(int raceId) {
        Race race = this.raceById.get(raceId);
        if (race.getParticipants().size() == 0) {
            return CANNOT_START_THE_RACE_WITH_ZERO_PARTICIPANTS;
        }

        this.raceById.remove(raceId);
        return race.start();
    }

    @Override
    public void park(int carId) {
        if (isInRace(carId)) {
            return;
        }

        Car car = this.carById.get(carId);
        this.garage.park(carId, car);
    }

    private boolean isInRace(int carId) {
        for (Race race : this.raceById.values()) {
            if (race.getParticipants().containsKey(carId)) {
                return true;
            }
        }

        return false;
    }

    private boolean isInGarage(int carId) {
        return this.garage.contains(carId);
    }

    @Override
    public void unpark(int carId) {
        Car unpark = this.garage.unpark(carId);
        this.carById.put(carId, unpark);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        this.garage.tune(tuneIndex, tuneAddOn);
    }

}
