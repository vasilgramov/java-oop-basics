package app.commands;

import app.core.managers.Manager;
import app.models.cars.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class RegisterCommand extends AbstractCommand {

    private static final String CARS_PATH = "app.models.cars.";
    private static final String CAR = "Car";

    public RegisterCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int id = Integer.parseInt(tokens[1]);
        String type = tokens[2];
        Class<?> carClass = Class.forName(CARS_PATH + type + CAR);

        Constructor<?> constructor = carClass.getDeclaredConstructor(
                String.class, String.class, int.class, int.class, int.class, int.class, int.class);
        Car car = ((Car) constructor.newInstance(
                tokens[3],
                tokens[4],
                Integer.parseInt(tokens[5]),
                Integer.parseInt(tokens[6]),
                Integer.parseInt(tokens[7]),
                Integer.parseInt(tokens[8]),
                Integer.parseInt(tokens[9])));

        super.getManager().registerCar(id, car);
        return null;
    }

}
