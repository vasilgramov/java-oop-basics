package app;

import java.util.HashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> carsById;
    private Map<Integer, Race> racesById;

    private Garage garage;

    public CarManager() {
        this.carsById = new HashMap<>();
        this.racesById = new HashMap<>();

        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        if (type.equals("Performance")) {
            Car car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.carsById.put(id, car);
        } else {
            Car car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.carsById.put(id, car);
        }
    }

    public String check(int id) {
        return this.carsById.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        if (type.equals("Drift")) {
            Race race = new DragRace(length, route, prizePool);
            this.racesById.put(id, race);
        } else if (type.equals("Casual")) {
            Race race = new CasualRace(length, route, prizePool);
            this.racesById.put(id, race);
        } else if (type.equals("Drag")) {
            Race race = new DragRace(length, route, prizePool);
            this.racesById.put(id, race);
        }
    }

    public void participate(int carId, int raceId) {
        if (!this.garage.containsCar(carId)) {
            Car car = this.carsById.get(carId);
            Race race = this.racesById.get(raceId);

            race.addCar(carId, car);
        }
    }

    public String start(int id) {
        Race race = this.racesById.get(id);

        if (race.getParticipantsCount() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s - %d\n", race.getRoute(), race.getLength()));
            builder.append(race.start());

            this.racesById.remove(id);

            return builder.toString();
        } else {
            return "Cannot start the race with zero participants.\n";
        }
    }

    public void park(int id) {
        boolean hasFound = false;

        for (Race race : racesById.values()) {
            if (race.containsCar(id)) {
                hasFound = true;
                break;
            }
        }

        if (!hasFound) {
            Car car = this.carsById.get(id);
            this.garage.parkCar(id, car);
        }
    }

    public void unpark(int id) {
        if (this.garage.containsCar(id)) {
            this.garage.unparkCar(id);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : this.garage.getCars()) {
            car.increaseHorsePower(tuneIndex);
            car.increaseSuspension(tuneIndex);

            if (car.getType().equals("Show")) {
                ShowCar showCar = (ShowCar)car;
                showCar.increaseStars(tuneIndex);
            } else {
                PerformanceCar performanceCar = (PerformanceCar)car;
                performanceCar.addAddon(addOn);
            }
        }
    }
}
