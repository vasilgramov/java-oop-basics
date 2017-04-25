package app.models.garages;

import app.models.cars.Car;

/**
 * Created by vladix on 4/25/17.
 */
public interface Garage {

    void park(int id, Car car);

    Car unpark(int id);

}
