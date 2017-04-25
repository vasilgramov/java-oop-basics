package app.models.garages;

import app.models.cars.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public class CarGarage implements Garage {

    private Map<Integer, Car> parkedCars;

    public CarGarage() {
        this.parkedCars = new HashMap<>();
    }

    @Override
    public void park(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    @Override
    public Car unpark(int id) {
        Car car = this.parkedCars.remove(id);

        return car;
    }

    @Override
    public boolean contains(int id) {
        return this.parkedCars.containsKey(id);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        for (Car car : this.parkedCars.values()) {
            car.tune(tuneIndex, tuneAddOn);
        }
    }

}
