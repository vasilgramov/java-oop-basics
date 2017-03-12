package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public void parkCar(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public boolean containsCar(int id) {
        return this.parkedCars.containsKey(id);
    }

    public void unparkCar(int id) {
        this.parkedCars.remove(id);
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        for (Car car : parkedCars.values()) {
            cars.add(car);
        }

        return cars;
    }
}
